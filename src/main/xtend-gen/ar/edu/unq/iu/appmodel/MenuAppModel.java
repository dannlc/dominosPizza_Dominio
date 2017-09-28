package ar.edu.unq.iu.appmodel;

import ar.edu.unq.iu.modelo.Ingrediente;
import ar.edu.unq.iu.modelo.Pizza;
import ar.edu.unq.iu.repo.RepoIngrediente;
import ar.edu.unq.iu.repo.RepoPizza;
import java.io.Serializable;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.uqbar.commons.applicationContext.ApplicationContext;
import org.uqbar.commons.model.annotations.Observable;

@Observable
@Accessors
@SuppressWarnings("all")
public class MenuAppModel implements Serializable {
  public RepoPizza getRepoPizza() {
    Object _singleton = ApplicationContext.getInstance().<Object>getSingleton(Pizza.class);
    return ((RepoPizza) _singleton);
  }
  
  public RepoIngrediente getRepoIngrediente() {
    Object _singleton = ApplicationContext.getInstance().<Object>getSingleton(Ingrediente.class);
    return ((RepoIngrediente) _singleton);
  }
}
