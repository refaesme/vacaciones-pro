package com.vacaciones.pro.enums;

import java.util.HashMap;
import java.util.Map;

public enum RolEnums {
	
	ADMIN(0),USER(1);

	private Integer rolID;
	
	private static final Map<Integer, RolEnums> roles = new HashMap<Integer, RolEnums>();

    static {
        for (RolEnums d : RolEnums.values()) {
        	roles.put(d.getAbbreviation(), d);
        }
    }

	RolEnums(int i) {
		this.rolID = i;
	}
	
	public Integer getAbbreviation() {
        return rolID;
    }

    public static RolEnums get(Integer idRol) {
        return roles.get(idRol);
    }

}
