package com.jagregory.shiro.freemarker;

/**
 * 多个权限存在时，符合任意其中一个权限就表示有效，目前微信、mec会用到
 */
public class HasAnyPermissionsTag extends PermissionTag {
    private static final String PERMISSION_NAMES_DELIMETER = ",";

    protected boolean showTagBody(String ps) {
        boolean hasAnyPermissions = false;
        for(String p : ps.split(PERMISSION_NAMES_DELIMETER)){
            if(isPermitted(p)){
                hasAnyPermissions = true;
                break;
            }
        }
        return hasAnyPermissions;
    }
}
