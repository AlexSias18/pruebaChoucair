package org.prueba.stepsdefinitions;

import io.cucumber.java.Scenario;
import io.cucumber.java.es.Entonces;
import net.thucydides.core.annotations.Steps;
import org.prueba.steps.InicioSteps;
import io.cucumber.java.es.Y;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import org.prueba.utils.Constants;
import org.prueba.utils.Utils;

public class PruebaStepsDef {
    private Scenario scenario;

    @Before()
    public void setScenario(Scenario scenario){
        //setUp
       this.scenario=scenario;
        Utils.saveVariableOnSession(Constants.SCENARIO,this.scenario);
    }


    @Steps
    InicioSteps inicioSteps;

    @Dado("que me encuentro en la página de login de Exito")
    public void que_me_encuentro_en_la_página_de_login_de_Exito(){
        inicioSteps.open();
    }
    @Cuando("selecciono una categoria y subcategoria")
    public void selecciono_una_categoria_y_subcategoria() throws InterruptedException {
        inicioSteps.elegirCategoria();
    }
    @Y("seleccione cinco productos con cantidades aleatorias")
        public void seleccioneCincoProductosConCantidadesAleatorias() throws InterruptedException {
            inicioSteps.elegirProductos();
    }

    @Entonces("realizo las validaciones necesarias")
    public void realizoLasValidacionesNecesarias() throws InterruptedException {
        inicioSteps.validarProductos();
    }
}
