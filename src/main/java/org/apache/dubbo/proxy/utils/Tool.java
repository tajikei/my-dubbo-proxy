package org.apache.dubbo.proxy.utils;

import org.apache.dubbo.metadata.definition.model.MethodDefinition;

public class Tool {
    public static String getInterface(String service) {
        if (service != null && service.length() > 0) {
            int i = service.indexOf('/');
            if (i >= 0) {
                service = service.substring(i + 1);
            }
            i = service.lastIndexOf(':');
            if (i >= 0) {
                service = service.substring(0, i);
            }
        }
        return service;
    }

    public static String getGroup(String service) {
        if (service != null && service.length() > 0) {
            int i = service.indexOf('/');
            if (i >= 0) {
                return service.substring(0, i);
            }
        }
        return null;
    }

    /**
     * 指定されたサービス文字列から抽出されたバージョンを返します。
     *
     * @param service バージョンを抽出する必要がある入力文字列。
     * @return サービス文字列から抽出されたバージョン。バージョンが見つからない場合は、null が返されます。
     */
    public static String getVersion(String service) {
        int a = 10;
        if (service != null && service.length() > 0) {
            int i = service.lastIndexOf(':');
            if (i >= 0) {
                return service.substring(i + 1);
            }
        }
        return null;
    }

    public static boolean sameMethod(MethodDefinition m, String methodName, int paramLen) {
        return (m.getName().equals(methodName) && m.getParameterTypes().length == paramLen);
    }
}
