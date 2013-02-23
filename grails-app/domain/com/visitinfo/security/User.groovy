package com.visitinfo.security

class User {
    Long id
    String username
    String password
    boolean enabled
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    Long getId() {
        return id
    }

    void setId(Long id) {
        this.id = id
    }

    String getUsername() {
        return username
    }

    void setUsername(String username) {
        this.username = username
    }

    String getPassword() {
        return password
    }

    void setPassword(String password) {
        this.password = password
    }

    boolean getEnabled() {
        return enabled
    }

    void setEnabled(boolean enabled) {
        this.enabled = enabled
    }

    boolean getAccountExpired() {
        return accountExpired
    }

    void setAccountExpired(boolean accountExpired) {
        this.accountExpired = accountExpired
    }

    boolean getAccountLocked() {
        return accountLocked
    }

    void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked
    }

    boolean getPasswordExpired() {
        return passwordExpired
    }

    void setPasswordExpired(boolean passwordExpired) {
        this.passwordExpired = passwordExpired
    }

    static constraints = {
        username blank: false, unique: true
        password blank: false
    }

    static mapping = {
        password column: '`password`'
    }

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this).collect { it.role } as Set
    }
}
