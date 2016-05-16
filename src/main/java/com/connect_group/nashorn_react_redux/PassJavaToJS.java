package com.connect_group.nashorn_react_redux;

        import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by arran on 16/05/16.
 */
public class PassJavaToJS {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");
        nashorn.eval("var callme = function(name) { return 'Hello ' + name; };");
        Invocable invocable = (Invocable) nashorn;
        String result = (String) invocable.invokeFunction("callme", "from Java!");
        System.out.println(result);
    }
}
