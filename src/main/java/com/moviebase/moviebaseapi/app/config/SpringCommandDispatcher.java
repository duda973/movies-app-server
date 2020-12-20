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
    private final Map<String, ICommandExecutor> rawMap;

    public SpringCommandDispatcher(Map<String, ICommandExecutor> rawMap) {
        this.rawMap = rawMap;
    }

    @PostConstruct
    private void setUp() {
        if (rawMap != null && !rawMap.isEmpty()) {
            for (ICommandExecutor commandExecutor : rawMap.values()) {
                Type command = ((ParameterizedType)commandExecutor.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
                preparedMap.put((Class) command, commandExecutor);
            }
        }
    }
}
