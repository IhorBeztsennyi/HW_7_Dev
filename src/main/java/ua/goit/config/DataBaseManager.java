package ua.goit.config;

import org.hibernate.Session;

public interface DataBaseManager {

    Session getSession();
}
