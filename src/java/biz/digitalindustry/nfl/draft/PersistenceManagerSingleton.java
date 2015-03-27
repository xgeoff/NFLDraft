/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package biz.digitalindustry.nfl.draft;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;

/**
 *
 * @author gporemba
 */
public class PersistenceManagerSingleton {
    
    private PersistenceManagerSingleton() {}
    
    private static final PersistenceManagerFactory persistenceManagerInstance =
      JDOHelper.getPersistenceManagerFactory("transactions-optional");

  /**
   * Returns an instance of the Persistence Manager.
   * @return persistence manager instance.
   */
  public static PersistenceManagerFactory getInstance() {
    return persistenceManagerInstance;
  }
}
