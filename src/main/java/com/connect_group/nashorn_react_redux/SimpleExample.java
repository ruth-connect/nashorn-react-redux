package com.connect_group.nashorn_react_redux;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by arran on 16/05/16.
 */
public class SimpleExample {
    public static void main(String[] args) throws ScriptException, IOException {
        ScriptEngine nashorn = new ScriptEngineManager().getEngineByName("nashorn");
        nashorn.eval("var foo = 'World!'; print('Hello', foo);");
        nashorn.eval(new FileReader("bundle.js"));
    }
}
