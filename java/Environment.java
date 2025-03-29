import java.util.HashMap;
import java.util.Map;

class Environment {
    private final Map<String, Object> values = new HashMap<>();
    final Environment enclosing;

    Environment () {
        enclosing = null;
    }

    Environment(Environment enclosing) {
        this.enclosing = enclosing;
    }

    Object get(Token name) {
        if (values.containsKey(name.lexeme)){
            return values.get(name.lexeme);
        }

        if (enclosing != null) return enclosing.get(name);

        throw new RuntimeError(name,
                "Undefined variable '" + name.lexeme + "'.");
    }

    void define(String name, Object value){
        values.put(name, value);
    }

    void assign(Token name, Object value){
        // The key must already exist to assign, meaning l-values should already exist/ been defined prior
        if(values.containsKey(name.lexeme)){
            values.put(name.lexeme, value);
            return;
        }

        //Cant find in local env, will look at parent env
        if (enclosing != null) {
            enclosing.assign(name, value);
        }
        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
    }

}