import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Conta {
	private boolean clienteEspecial;
	private Double saldo;
	private Double saque;
	
	/**
	 *	@param saldo representa o valor que .
	 *	@implNote o método atribui o valor do parâmetro ao atributo "saldo" da conta,
	 *	define o cliente como especial, e verifica se o valor do atributo é diferente de -200, 
	 *	caso seja diferente, é jogada uma exceção.
	 */
	@Given("um cliente especial atual com o saldo de {double} reais")
	public boolean saldoClienteEspecial(Double saldo) throws Throwable {
		this.clienteEspecial = true;
	    if (this.saldo != saldo) {
	    	this.saldo = saldo;
	    	return true;
	    } else {
	    	throw new PendingException("Valores iguais, portanto não é necessário atualizar.");
	    }
	}
	
	/**
	 *	@param saque representa o valor que será retirado.
	 *	@implNote o método atribui o valor do parâmetro ao atributo "saque" da conta,
	 *	e verifica se o valor do atributo é diferente de 100, caso seja diferente, 
	 *	é jogada uma exceção.
	 */
	@When("for solicitado um saque no valor de {double} reais")
	public boolean verificarSaqueClienteEspecial(Double saque) throws Throwable {
	    if (saque > 0) {
	    	this.saque = saque;
	    	return true;
	    } else {
	    	throw new PendingException("Insira um valor maior que zero.");
	    }
	}

	/**
	 *	@param saldo representa o valor total na conta do cliente.
	 *	@implNote o método verifica se a subtração do atributo "saldo" pelo "saque"
	 *	é igual a -300 e se o cliente é especial, caso ambas as condições sejam verdadeiras, 
	 *	o "saldo" e o "saque" são atualizados, senão é jogada uma exceção.
	 */
	@Then("deve efetuar o saque e atualizar o saldo da conta para {double} reais")
	public boolean sacarClienteEspecial(Double saldo) throws Throwable {
		if ((this.saldo -= this.saque) == saldo) {
			sacar();
			return true;
		} else {
			throw new PendingException("Saldo Insuficiente.");
		}
	}
	
	/**
	 *	@param saldo representa o valor total na conta do cliente.
	 *	@implNote o método atribui o valor do parâmetro ao atributo "saldo" da conta,
	 *	define o cliente como comum, e verifica se o valor do atributo é diferente de -200, 
	 *	caso seja diferente, é jogada uma exceção.
	 */
	@Given("um cliente comum com saldo atual de {double} reais")
	public boolean saldoClienteComum(Double saldo) throws Throwable {
		if (this.saldo != saldo) {
	    	this.saldo = saldo;
	    	return true;
	    } else {
	    	throw new PendingException("Valores iguais, portanto não é necessário atualizar.");
	    }
	}

	/**
	 *	@param saque representa o valor que será retirado.
	 *	@implNote o método atribui o valor do parâmetro ao atributo "saque" da conta,
	 *	e verifica se o valor do atributo é diferente de 200, caso seja diferente, 
	 *	é jogada uma exceção.
	 */
	@When("solicitar um saque de {double} reais")
	public boolean verificarSaqueClienteComum(Double saque) throws Throwable {
		if (saque > 0) {
	    	this.saque = saque;
	    	return true;
	    } else {
	    	throw new PendingException("Insira um valor maior que zero.");
	    }
	}
	
	/**
	 *	@implNote o método verifica se o atributo "saldo" é negativo
	 *	e se o cliente é comum, caso ambas as condições sejam verdadeiras, 
	 *	é a apresentada uma mensagem, senão é jogada uma exceção.
	 */
	@Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public boolean sacarClienteComum() throws Throwable {
		if (sacar()) {
			return true;
		} else {
			throw new PendingException("Saldo Insuficiente.");
		}
	}
	
	private boolean sacar() {
		if (this.saldo < this.saque) {
			if (this.clienteEspecial) {
				this.saldo -= this.saque;
				return true;
			} else {
				return false;
			}
		} else {
			this.saldo -= this.saque;
			return true;
		}
	}
}
