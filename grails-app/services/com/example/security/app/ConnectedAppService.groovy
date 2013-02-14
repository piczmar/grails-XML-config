package com.example.security.app;


import com.springsource.greenhouse.develop.AppForm
import com.springsource.greenhouse.develop.AppRepository
import com.springsource.greenhouse.develop.AppSummary
import com.springsource.greenhouse.develop.InvalidApiKeyException
import grails.custom.security.App
import org.springframework.jdbc.core.RowMapper

import java.sql.ResultSet
import java.sql.SQLException
import org.springframework.security.crypto.encrypt.Encryptors

public class ConnectedAppService implements AppRepository{

    def sessionFactory
    def encryptor = Encryptors.noOpText()

    private static final String SELECT_APPS = "select a.name, a.slug, a.description from App a inner join AppDeveloper d on a.id = d.app where d.member = :memberId";

    private static final String SELECT_APP_BY_SLUG = "select a.name, a.slug, a.description, a.apiKey, a.secret, a.callbackUrl from App a inner join AppDeveloper d on a.id = d.app where d.member = :accountId and a.slug = :slug";

    private static final String SELECT_APP_BY_API_KEY = "select a.name, a.slug, a.description, a.apiKey, a.secret, a.callbackUrl from App a where a.apiKey = ?";

    private static final String SELECT_APP_FORM = "select a.name, a.description, a.organization, a.website, a.callbackUrl from App a inner join AppDeveloper d on a.id = d.app where d.member = ? and a.slug = ?";

    private static final String UPDATE_APP_FORM = "update App set name = ?, slug = ?, description = ?, organization = ?, website = ?, callbackUrl = ? where exists(select 1 from AppDeveloper where member = ?) and slug = ?";

    private static final String DELETE_APP = "delete from App where exists(select 1 from AppDeveloper where member = ?) and slug = ?";

    private static final String INSERT_APP = "insert into App (name, slug, description, organization, website, apiKey, secret, callbackUrl) values (?, ?, ?, ?, ?, ?, ?, ?)";

    private static final String INSERT_APP_DEVELOPER = "insert into AppDeveloper (app, member) values (?, ?)";


    @Override
    public List<AppSummary> findAppSummaries(Long accountId) {
        def session = sessionFactory.getCurrentSession()
        def query = session.createSQLQuery(SELECT_APPS);
        query.setLong("memberId", accountId);
        query.addEntity(AppSummary.class)
        return query.list()
    }

    @Override
    public App findAppBySlug(Long accountId, String slug) {
        def session = sessionFactory.getCurrentSession()
        def query = session.createSQLQuery(SELECT_APP_BY_SLUG);
        query.setLong("accountId", accountId);
        query.setLong("slug", slug);
        query.addEntity(App.class)
        return query.list().get(0)
    }

    @Override
    public String updateApp(Long accountId, String slug, AppForm form) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deleteApp(Long accountId, String slug) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AppForm getNewAppForm() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public AppForm getAppForm(Long accountId, String slug) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String createApp(Long accountId, AppForm form) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public App findAppByApiKey(String apiKey) throws InvalidApiKeyException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }



    private RowMapper<AppSummary> appSummaryMapper = new RowMapper<AppSummary>() {
        public AppSummary mapRow(ResultSet rs, int rowNum) throws SQLException {
            // TODO this is currently hardcoded
            String iconUrl = "http://images.greenhouse.springsource.org/apps/icon-default-app.png";
            return new AppSummary(rs.getString("name"), iconUrl, rs.getString("description"), rs.getString("slug"));
        }
    };

    private RowMapper<App> appMapper = new RowMapper<App>() {
        public App mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new App(appSummaryMapper.mapRow(rs, rowNum), encryptor.decrypt(rs.getString("apiKey")), encryptor.decrypt(rs.getString("secret")), rs.getString("callbackUrl"));
        }
    };

    private RowMapper<AppForm> appFormMapper = new RowMapper<AppForm>() {
        public AppForm mapRow(ResultSet rs, int rowNum) throws SQLException {
            AppForm form = new AppForm();
            form.setName(rs.getString("name"));
            form.setDescription(rs.getString("description"));
            form.setOrganization(rs.getString("organization"));
            form.setWebsite(rs.getString("website"));
            form.setCallbackUrl(rs.getString("callbackUrl"));
            return form;
        }
    };
}
