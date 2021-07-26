package club.dlblog.param.transfer.engine;

import org.springframework.stereotype.Component;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author chaolei
 */
@Component
public class TransferEngineManger {


    private static ThreadLocal<TransferEngine> transferEngine = new ThreadLocal<>();

    private ScriptEngineManager scriptEngineManager = new ScriptEngineManager();

    public TransferEngine getEngine(String engineName){
        if(transferEngine.get()==null) {
            ScriptEngine se = scriptEngineManager.getEngineByName(engineName);
            TransferEngine engine = (json,js)->{
                String result = null;
                try {
                    se.eval(js);
                } catch (ScriptException e) {
                    e.printStackTrace();
                }
                if(se instanceof Invocable){
                    try {
                      result = (String) ((Invocable) se).invokeFunction("transfer",json);
                    } catch (ScriptException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                }
                return result;
            };
            transferEngine.set(engine);
        }
        return transferEngine.get();
    }
}
