import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Conta {
	Integer saldo;
	Integer saque;
	boolean clienteEspecial;
	
	/**
	 * 
	 *	@param saldo representa o valor total na conta do cliente.
	 *	@implNote o método verifica se o valor passado para o parametro é igual a -200.
	 */
	@Given("um cliente atual com o saldo de {int} reais")
	public void um_cliente_atual_com_o_saldo_de_reais(Integer saldo) {
	    this.saldo = saldo;
	    
	    if (this.saldo != -200) {
	    	throw new io.cucumber.java.PendingException();
	    }
	}
	
	/**
	 * 
	 *	@param saque representa o valor que será retirado.
	 *	@implNote o método verifica se o valor passado para o parametro é igual a 100.
	 */
	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer saque) {
	    this.saque = saque;
	    
	    if (this.saque != 100) {
	    	throw new io.cucumber.java.PendingException();
	    }
	}

	/**
	 * 
	 *	@param saldo representa o valor total na conta do cliente.
	 *	@implNote o método verifica se o valor passado para o parametro é igual a -300.
	 */
	@Then("deve efetuar o saque e atualizar o  saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer saldo) { 
		this.clienteEspecial = true;
	    if ((this.saldo -= this.saque) == -300 && this.clienteEspecial) {
	    	this.saldo = saldo;
	    	this.saque = 0;
	    } else {
	    	throw new io.cucumber.java.PendingException();
	    }
	}
	
	/**
	 * 
	 *	@param saldo representa o valor total na conta do cliente.
	 *	@implNote o método verifica se o valor passado para o parametro é igual a -300.
	 */
	@Given("um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer saldo) {
	    this.saldo = saldo;
	    
	    if (this.saldo != -300) {
	    	throw new io.cucumber.java.PendingException();
	    }
	}

	/**
	 * 
	 *	@param saque representa o valor que será retirado.
	 *	@implNote o método verifica se o valor passado para o parametro é igual a -200.
	 */
	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer saque) {
		this.saque = saque;
	    
	    if (this.saque != -200) {
	    	throw new io.cucumber.java.PendingException();
	    }
	}
	
	/**
	 * 
	 *	@implNote o método verifica se o saldo é maior que zero e se é cliente especial.
	 */
	@Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
		this.clienteEspecial = false;
		if (this.saldo < 0 && !this.clienteEspecial) {
			System.out.println("Saldo Insuficiente");
		} else {
			throw new io.cucumber.java.PendingException();
		}
	}

}
