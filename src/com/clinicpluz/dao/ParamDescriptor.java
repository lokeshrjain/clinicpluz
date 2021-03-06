package com.clinicpluz.dao;

import java.sql.Types;
import java.util.Date;

public class ParamDescriptor {
	
	// Constructor itself is private, we are encapsulating so that
    // you don't need to write java.sql.Types constants yourself
    private ParamDescriptor(int dataType, Object value) {
        _dataType = dataType;
        _value = value;
    }

    // Factory methods for actual instantiation
    public static ParamDescriptor forInt (int paramVal) {
        return new ParamDescriptor (Types.INTEGER, paramVal);
    }

    public static ParamDescriptor forString (String paramVal) {
        return new ParamDescriptor (Types.VARCHAR, paramVal);
    }

    public static ParamDescriptor forDate (Date paramVal) {
        return new ParamDescriptor (Types.DATE, paramVal);
    }

    public static ParamDescriptor forTime (Date paramVal) {
        return new ParamDescriptor (Types.TIMESTAMP , paramVal);
    }
    public static ParamDescriptor forTEXT (String paramVal) {
        return new ParamDescriptor (Types.LONGVARCHAR , paramVal);
    }

    
    // Add more here to support more data types . . . .    


    public int getDataType() {
        return _dataType;
    }

    public Object getValue() {
        return _value;
    }

    private int     _dataType;
    private Object  _value;
}


