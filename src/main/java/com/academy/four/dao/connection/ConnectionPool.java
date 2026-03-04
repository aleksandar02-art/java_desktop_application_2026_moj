package com.academy.four.dao.connection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    private List<Connection> availableConnections = new ArrayList<>();
    private List<Connection> inUseConnections = new ArrayList<>();

}
