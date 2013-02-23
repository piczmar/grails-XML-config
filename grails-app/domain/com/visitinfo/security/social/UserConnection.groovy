package com.visitinfo.security.social

class UserConnection implements Serializable {


    static constraints = {
        userId(nullable: false, maxSize: 255)
        providerId(nullable: false, maxSize: 255)
        providerUserId(nullable: true, maxSize: 255)
        rank(nullable: false)
        displayName(nullable: true, maxSize: 255)
        profileUrl(nullable: true, maxSize: 512)
        imageUrl(nullable: true, maxSize: 512)
        accessToken(nullable: false, maxSize: 255)
        secret(nullable: true, maxSize: 255)
        refreshToken(nullable: true, maxSize: 255)
        userId(unique: ['providerId', 'rank'])
    }
    static mapping = {
        table(name: 'userconnection')
        id composite: ['userId', 'providerId', 'rank']
        columns {
            userId column: "USERID"
            providerId column:"PROVIDERID"
            providerUserId column:"PROVIDERUSERID"
            rank column:"RANK"
            displayName column:"DISPLAYNAME"
            profileUrl column:"PROFILEURL"
            imageUrl column:"IMAGEURL"
            accessToken column:"ACCESSTOKEN"
            secret column:"SECRET"
            refreshToken column:"REFRESHTOKEN"
            expireTime column:"EXPIRETIME"
        }
        version false
    }

    String userId
    String providerId
    String providerUserId
    BigDecimal rank
    String displayName
    String profileUrl
    String imageUrl
    String accessToken
    String secret
    String refreshToken
    BigDecimal expireTime
}

/*


create table UserConnection (
    userId varchar(255) not null,
	providerId varchar(255) not null,
	providerUserId varchar(255),
	rank int not null,
	displayName varchar(255),
	profileUrl varchar(512),
	imageUrl varchar(512),
	accessToken varchar(255) not null,
	secret varchar(255),
	refreshToken varchar(255),
	expireTime bigint,
	primary key (userId, providerId, providerUserId));
create unique index UserConnectionRank on UserConnection(userId, providerId, rank);

*/