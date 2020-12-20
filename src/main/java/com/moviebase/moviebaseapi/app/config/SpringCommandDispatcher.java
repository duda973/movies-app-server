package com.moviebase.moviebaseapi.app.config;

import com.moviebase.moviebaseapi.app.bl.command.base.CommandDispatcher;
import com.moviebase.moviebaseapi.app.bl.command.base.CommandExecutor;
import com.moviebase.moviebaseapi.app.bl.command.base.ICommandExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

@Service
public class SpringCommandDispatcher extends CommandDispatcher {
    private final Map<String, CommandExecutor> rawMap;

    public SpringCommandDispatcher(Map<String, CommandExecutor> rawMap) {
        this.rawMap = rawMap;
    }

    @PostConstruct
    private void setUp() {
        if (rawMap != null && !rawMap.isEmpty()) {
            for (CommandExecutor commandExecutor : rawMap.values()) {
                ParameterizedType type = (ParameterizedType) commandExecutor.getClass().getGenericSuperclass();
                Type superClass = type.getActualTypeArguments()[0];
                preparedMap.put((Class) superClass, commandExecutor);
            }
        }
    }
}
