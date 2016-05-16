package com.connect_group.nashorn_react_redux;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by arran on 16/05/16.
 */
public class InvokeJSFromJava {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");
        nashorn.eval("var callme = function(name) { return 'Hello ' + name; };");

        // Create JavaScript object.
        nashorn.eval("var obj = new Object()");
        nashorn.eval("obj.greet = function(name) { print('Hello', name); };");

        // Get a handle on the JavaScript object here.
        Object obj = nashorn.get("obj");

        Invocable invocable = (Invocable) nashorn;
        invocable.invokeMethod(obj, "greet", "World!");
    }
}