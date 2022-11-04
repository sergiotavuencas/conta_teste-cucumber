import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Conta {
	Integer saldo;
	Integer saque;
	boolean clienteEspecial;
	
	/**
	 *	@param saldo representa o valor total na conta do cliente.
	 *	@implNote o método atribui o valor do parâmetro ao atributo "saldo" da conta,
	 *	define o cliente como especial, e verifica se o valor do atributo é diferente de -200, 
	 *	caso seja diferente, é jogada uma exceção.
	 */
	@Given("um cliente atual com o saldo de {int} reais")
	public void um_cliente_atual_com_o_saldo_de_reais(Integer saldo) {
	    this.saldo = saldo;
	    this.clienteEspecial = true;
	    if (this.saldo != -200) {
	    	throw new io.cucumber.java.PendingException();
	    }
	}
	
	/**
	 *	@param saque representa o valor que será retirado.
	 *	@implNote o método atribui o valor do parâmetro ao atributo "saque" da conta,
	 *	e verifica se o valor do atributo é diferente de 100, caso seja diferente, 
	 *	é jogada uma exceção.
	 */
	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer saque) {
	    this.saque = saque;
	    if (this.saque != 100) {
	    	throw new io.cucumber.java.PendingException();
	    }
	}

	/**
	 *	@param saldo representa o valor total na conta do cliente.
	 *	@implNote o método verifica se a subtração do atributo "saldo" pelo "saque"
	 *	é igual a -300 e se o cliente é especial, caso ambas as condições sejam verdadeiras, 
	 *	o "saldo" e o "saque" são atualizados, senão é jogada uma exceção.
	 */
	@Then("deve efetuar o saque e atualizar o  saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer saldo) {
	    if ((this.saldo -= this.saque) == -300 && this.clienteEspecial) {
	    	this.saldo = saldo;
	    	this.saque = 0;
	    } else {
	    	throw new io.cucumber.java.PendingException();
	    }
	}
	
	/**
	 *	@param saldo representa o valor total na conta do cliente.
	 *	@implNote o método atribui o valor do parâmetro ao atributo "saldo" da conta,
	 *	define o cliente como comum, e verifica se o valor do atributo é diferente de -200, 
	 *	caso seja diferente, é jogada uma exceção.
	 */
	@Given("um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer saldo) {
	    this.saldo = saldo;
	    this.clienteEspecial = false;
	    if (this.saldo != -300) {
	    	throw new io.cucumber.java.PendingException();
	    }
	}

	/**
	 *	@param saque representa o valor que será retirado.
	 *	@implNote o método atribui o valor do parâmetro ao atributo "saque" da conta,
	 *	e verifica se o valor do atributo é diferente de 200, caso seja diferente, 
	 *	é jogada uma exceção.
	 */
	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer saque) {
		this.saque = saque;
	    if (this.saque != 200) {
	    	throw new io.cucumber.java.PendingException();
	    }
	}
	
	/**
	 *	@implNote o método verifica se o atributo "saldo" é negativo
	 *	e se o cliente é comum, caso ambas as condições sejam verdadeiras, 
	 *	é a apresentada uma mensagem, senão é jogada uma exceção.
	 */
	@Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
		if (this.saldo < 0 && !this.clienteEspecial) {
			System.out.println("Saldo Insuficiente");
		} else {
			throw new io.cucumber.java.PendingException();
		}
	}

}
