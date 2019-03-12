/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comando190.util;

import com.fasterxml.classmate.AnnotationConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Fernado Luiz
 */
public class DAO {
    protected DAO() {
    }
 
    public static Session getSession() {
        Session session = (Session) DAO.session.get();
         
        if (session == null) {
            session = sessionFactory.openSession();
            DAO.session.set(session);
        }
     
        return session;
    }
 
    protected void begin() {
        getSession().beginTransaction();
    }
 
    protected void commit() {
        getSession().getTransaction().commit();
    }
 
    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch( HibernateException e ) {
            System.out.println("Não foi possível fazer rollback da transação");
        }
 
        try {
            getSession().close();
        } catch( HibernateException e ) {
            System.out.println("Não foi possível fazer fechar a sessão");
        }
 
        DAO.session.set(null);
    }
 
    public static void close() {
        getSession().close();
        DAO.session.set(null);
    }
 
    private static final ThreadLocal session = new ThreadLocal();
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
}

