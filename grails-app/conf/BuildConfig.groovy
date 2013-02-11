grails.servlet.version = "2.5" // Change depending on target container compliance (2.5 or 3.0)
grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
grails.project.target.level = 1.6
grails.project.source.level = 1.6
//grails.project.war.file = "target/${appName}-${appVersion}.war"

// uncomment (and adjust settings) to fork the JVM to isolate classpaths
//grails.project.fork = [
//   run: [maxMemory:1024, minMemory:64, debug:false, maxPerm:256]
//]
//grails.project.web.xml = "web-app/WEB-INF/web.xml"

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // specify dependency exclusions here; for example, uncomment this to disable ehcache:
        // excludes 'ehcache'
    }
    log "error" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    checksums true // Whether to verify checksums on resolve
    legacyResolve false // whether to do a secondary resolve on plugin installation, not advised and here for backwards compatibility

    repositories {
        inherits true // Whether to inherit repository definitions from plugins

        grailsPlugins()
        grailsHome()
        grailsCentral()

        mavenLocal()
        mavenCentral()

        // uncomment these (or add new ones) to enable remote dependency resolution from public Maven repositories
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }

    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes e.g.

        // runtime 'mysql:mysql-connector-java:5.1.20'
        compile('org.springframework.security:spring-security-core:3.1.0.RELEASE') {
//			transitive = false
            excludes 'spring-expression', 'spring-core', 'spring-context', 'spring-tx',
                    'spring-aop', 'spring-jdbc', 'spring-web', 'spring-test', 'aspectjrt',
                    'aspectjweaver', 'cglib-nodep', 'ehcache', 'commons-collections',
                    'hsqldb', 'jsr250-api', 'log4j', 'junit', 'mockito-core', 'jmock-junit4'
        }

        compile('org.springframework.security:spring-security-web:3.1.0.RELEASE') {
//			transitive = false
            excludes 'spring-security-core', 'spring-web', 'spring-jdbc', 'spring-test',
                    'commons-codec', 'hsqldb', 'servlet-api', 'junit', 'mockito-core', 'jmock-junit4'
        }
        compile('org.springframework.security:spring-security-config:3.1.0.RELEASE') {
            excludes 'spring-security-core', 'spring-security-web', 'spring-web', 'commons-logging', 'servlet-api',
                    'spring-beans', 'spring-core', 'spring-context', 'spring-aop', 'aspectjweaver', 'aopalliance'
        }
        compile('org.codehaus.spring-security-oauth:spring-security-oauth:3.10')
        test('org.apache.httpcomponents:httpclient:4.2.3')

    }

    plugins {
        runtime ":hibernate:$grailsVersion"
        runtime ":jquery:1.8.3"
        //runtime ":resources:1.1.6"

        // Uncomment these (or add new ones) to enable additional resources capabilities
        //runtime ":zipped-resources:1.0"
        //runtime ":cached-resources:1.0"
        //runtime ":yui-minify-resources:0.1.4"

        build ":tomcat:$grailsVersion"

        runtime ":database-migration:1.2.1"

        //compile ':cache:1.0.1'
    }
}
