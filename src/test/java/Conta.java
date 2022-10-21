import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Conta {
	double saldo;
	double saque;
	
	@Given("um cliente atual com o saldo de {int} reais")
	public void um_cliente_atual_com_o_saldo_de_reais(Integer int1) {
	    this.saldo = int1;
	    
	    if (this.saldo != int1) {
	    	throw new io.cucumber.java.PendingException();
	    }
	}

	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer int1) {
	    this.saque = int1;
	    
	    if (this.saque != int1) {
	    	throw new io.cucumber.java.PendingException();
	    }
	}

	@Then("deve efetuar o saque e atualizar o  saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer int1) { 
	    if ((this.saldo -= this.saque) == int1) {
	    	this.saldo = int1;
	    	this.saque = 0;
	    } else {
	    	throw new io.cucumber.java.PendingException();
	    }
	}

	@Given("um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer int1) {
	    this.saldo = int1;
	    
	    if (this.saldo != int1) {
	    	throw new io.cucumber.java.PendingException();
	    }
	}

	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer int1) {
		this.saque = int1;
	    
	    if (this.saque != int1) {
	    	throw new io.cucumber.java.PendingException();
	    }
	}

	@Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
		if (this.saldo < 0) {
			System.out.println("Saldo Insuficiente");
		} else {
			throw new io.cucumber.java.PendingException();
		}
	}

}
