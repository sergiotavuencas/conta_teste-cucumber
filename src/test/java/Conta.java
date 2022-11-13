import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * 
 * @author Sérgio Vicente Tavuencas
 *
 */
public class Conta {
	private boolean clienteEspecial = false;
	private Double saldoCliente;
	private Double saqueCliente;
	
	/**
	 *	@param saldo representa o valor que será atribuído a variável saldoCliente.
	 *	@implNote O método verifica se o tipo de cliente é especial, caso seja,
	 *	altera o valor do saldo, senão, joga uma exceção.
	 */
	@Given("um cliente especial atual com o saldo de {double} reais")
	public void um_cliente_especial_atual_com_o_saldo_de_reais(Double saldo) throws Throwable {
		if (this.clienteEspecial) {
			this.saldoCliente = (saldo != 0) ? saldo : -200.0;
		} else {
			throw new PendingException("Erro ao definir o saldo, cliente especial: Cliente diferente do esperado, nesse caso, 'especial'.");
		}
	}
	
	/**
	 *	@param saque representa o valor que será atribuído a variável saqueCliente.
	 *	@implNote O método verifica se o tipo de cliente é especial, caso não seja,
	 *	joga uma exceção, se for especial, verifica se o saque é maior que zero,
	 *	caso seja, atribui o valor recebido, senão atribui 100.
	 */
	@When("for solicitado um saque no valor de {double} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Double saque) throws Throwable {
	    if (this.clienteEspecial) {
	    	this.saqueCliente = (saque > 0) ? saque : 100.0;
	    } else {
	    	throw new PendingException("Erro ao verificar o saque, cliente especial: Cliente diferente do esperado, nesse caso, 'especial'.");
	    }
	}

	/**
	 *	@param saldo representa o valor que será atribuído a variável saldoCliente.
	 *	@implNote O método verifica o tipo de cliente é especial, caso não seja,
	 *	joga uma exceção, se for especial, verifica se a subtração entre o saldo
	 *	e o saque do cliente é igual ao valor recebido, caso seja, atribui o
	 *	valor recebido, senão, atribui -300.
	 */
	@Then("deve efetuar o saque e atualizar o saldo da conta para {double} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Double saldo) throws Throwable {
		if (this.clienteEspecial) {
			this.saldoCliente = ((this.saldoCliente - this.saqueCliente) == saldo) ? saldo : -300.0;
			this.saqueCliente = 0.0;
		} else {
			throw new PendingException("Erro ao sacar, cliente especial: Cliente diferente do esperado, nesse caso, 'especial'.");
		}
	}
	
	/**
	 *	@param saldo representa o valor que será atribuído a variável saldoCliente.
	 *	@implNote O método verifica se o tipo de cliente é comum, caso seja,
	 *	altera o valor do saldo, senão, joga uma exceção.
	 */
	@Given("um cliente comum com saldo atual de {double} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Double saldo) throws Throwable {
		if (!this.clienteEspecial) {
			this.saldoCliente = (saldo != 0) ? saldo : -300.0;
		} else {
			throw new PendingException("Erro ao definir o saldo, cliente comum: Cliente diferente do esperado, nesse caso, 'comum'.");
		}
	}

	/**
	 *	@param saque representa o valor que será atribuído a variável saqueCliente.
	 *	@implNote O método verifica se o tipo de cliente é comum, caso não seja, joga
	 *	uma exceção, senão, verifica se o saque é maior que zero, caso seja, atribui
	 *	o valor recebido, senão atribui 200.
	 */
	@When("solicitar um saque de {double} reais")
	public void solicitar_um_saque_de_reais(Double saque) throws Throwable {
		if (!this.clienteEspecial) {
			this.saqueCliente = (saque > 0) ? saque : 200;
	    } else {
	    	throw new PendingException("Erro ao verificar o saque, cliente comum: Cliente diferente do esperado, nesse caso, 'comum'.");
	    }
	}
	
	/**
	 *	@param saldo representa o valor que será atribuído a variável saldoCliente.
	 *	@implNote O método verifica se o tipo de cliente é comum, caso não seja,
	 *	joga uma exceção, senão verifica se o saldo é maior que o saque, caso seja,
	 *	o saldo e o saque são atualizados, senão, é jogada uma exceção.
	 */
	@Then("não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void nao_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() throws Throwable {
		if (!this.clienteEspecial) {
			if (this.saldoCliente > this.saqueCliente) {
				this.saldoCliente -= this.saqueCliente;
				this.saqueCliente = 0.0;
			} else {
				throw new PendingException("Saldo Insuficiente.");
			}
		} else {
			throw new PendingException("Erro ao sacar, cliente comum: Cliente diferente do esperado, nesse caso, 'especial'.");
		}
	}
}
