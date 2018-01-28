package network.data;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FastDataObject {
    private String split=":";
    private String dataName;
    private Map<String, String> params = new HashMap<>();
    private Set keySet;
    public FastDataObject(String data)
    {
        int l1 = data.split(";").length;
        String[] parse = new String[l1];
        parse = data.split(";");
        for (String vals:parse)
        {
            String[] keysik = vals.split(":");
            params.put(keysik[0], keysik[1]);
        }
        keySet=params.keySet();
    }

    public FastDataObject(byte[] bytes)
    {
        String data = new String(bytes, 0, bytes.length);
        int l1 = data.split(";").length;
        String[] parse = new String[l1];
        parse = data.split(";");
        for (String vals:parse)
        {
            String[] keysik = vals.split(":");
            params.put(keysik[0], keysik[1]);
        }
        keySet=params.keySet();
    }


    public FastDataObject(){}

    public void addFloat(String key, Float value)
    {
        params.put(key, value.toString());
        keySet=params.keySet();
    }

    public void addInt(String key, Integer value)
    {
        params.put(key, value.toString());
        keySet=params.keySet();
    }

    public void addString(String key, String value)
    {
        params.put(key, value);
        keySet=params.keySet();
    }

    public void addBoolean(String key, Boolean value)
    {
        params.put(key, value.toString());
        keySet=params.keySet();
    }

    public void addDouble(String key, Double value)
    {
        params.put(key, value.toString());
        keySet=params.keySet();
    }

    public byte[] generateData()
    {
        String result="";
        Collection<String> param = params.values();
        Set<String> keys = params.keySet();
        String[] key = (String[])keys.toArray();
        String[] dataStrings = (String[]) param.toArray();
        for(String string:key)
        {
            result+=string+":"+params.get(key)+";";
        }
        return result.getBytes();
    }

    public String generateString()
    {
        String result="";
        Collection<String> param = params.values();
        Set<String> keys = params.keySet();
        String[] key = (String[])keys.toArray();
        String[] dataStrings = (String[]) param.toArray();
        for(String string:key)
        {
            result+=string+":"+params.get(key)+";";
        }
        return result;
    }

    public String getParameter(int i)
    {
        return params.get(getKey(i));
    }

    public String getParameter(String Key)
    {
        return params.get(Key);
    }

    public float getFloat(String key)
    {
        return Float.parseFloat(params.get(key));
    }

    public float getFloat(int key)
    {
        return Float.parseFloat(params.get(getKey(key)));
    }

    public int getInt(String key)
    {
        return Integer.parseInt(params.get(key));
    }

    public int getInt(int key)
    {
        return Integer.parseInt(params.get(getKey(key)));
    }

    public String getString(String key)
    {
        return params.get(key);
    }

    public String getString(int key)
    {
        return params.get(getKey(key));
    }

    private String getKey(int i)
    {
        String[] keys =  (String[]) keySet.toArray();
        return keys[i];
    }
}