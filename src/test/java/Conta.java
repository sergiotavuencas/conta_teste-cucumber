import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Conta {
	private boolean clienteEspecial;
	private Double saldoCliente;
	private Double saqueCliente;
	
	/**
	 * 	@author Sérgio Vicente Tavuencas
	 *	@param saldo representa o valor que será atribuído a variável saldoCliente.
	 *	@implNote O método define o tipo de cliente para especial e define um valor 
	 *	para o saldoCliente.
	 */
	@Given("um cliente especial atual com o saldo de {double} reais")
	public void um_cliente_especial_atual_com_o_saldo_de_reais(Double saldo) {
		this.clienteEspecial = true;
		this.saldoCliente = saldo;
	}
	
	/**
	 * 	@author Sérgio Vicente Tavuencas
	 *	@param saque representa o valor que será atribuído a variável saqueCliente.
	 *	@implNote O método verifica o tipo de cliente e se o saldo é maior que zero,
	 *	então define um valor para o saqueCliente.
	 */
	@When("for solicitado um saque no valor de {double} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Double saque) throws Throwable {
	    if (this.clienteEspecial) {
	    	if (saque > 0) {
	    		this.saqueCliente = saque;
	    	} else {
	    		throw new PendingException("Erro ao verificar o saque, cliente especial: Valor deve ser maior que zero.");
	    	}
	    } else {
	    	throw new PendingException("Erro ao verificar o saque, cliente especial: Cliente diferente do esperado, nesse caso, 'especial'.");
	    }
	}

	/**
	 * 	@author Sérgio Vicente Tavuencas
	 *	@param saldo representa o valor que será atribuído a variável saldoCliente.
	 *	@implNote O método verifica o tipo de cliente, efetua uma subtração entre
	 *	saldoCliente e saqueCliente, então verifica se o resultado corresponde com
	 *	o parâmetro recebido.
	 */
	@Then("deve efetuar o saque e atualizar o saldo da conta para {double} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Double saldo) throws Throwable {
		if (this.clienteEspecial) {
			if ((this.saldoCliente - this.saqueCliente) == saldo) {
				this.saldoCliente = saldo;
				this.saqueCliente = 0.0;
			} else {
				throw new PendingException("Erro ao sacar, cliente especial: Valor do saldo diferente do esperado.");
			}
		} else {
			throw new PendingException("Erro ao sacar, cliente especial: Cliente diferente do esperado, nesse caso, 'especial'.");
		}
	}
	
	/**
	 * 	@author Sérgio Vicente Tavuencas
	 *	@param saldo representa o valor que será atribuído a variável saldoCliente.
	 *	@implNote O método define um valor para o saldoCliente.
	 */
	@Given("um cliente comum com saldo atual de {double} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Double saldo) throws Throwable {
		this.saldoCliente = saldo;
	}

	/**
	 * 	@author Sérgio Vicente Tavuencas
	 *	@param saque representa o valor que será atribuído a variável saqueCliente.
	 *	@implNote O método verifica o tipo de cliente e se o saldo é maior que zero,
	 *	então define um valor para o saqueCliente.
	 */
	@When("solicitar um saque de {double} reais")
	public void solicitar_um_saque_de_reais(Double saque) throws Throwable {
		if (!this.clienteEspecial) {
	    	if (saque > 0) {
	    		this.saqueCliente = saque;
	    	} else {
	    		throw new PendingException("Erro ao verificar o saque, cliente comum: Valor deve ser maior que zero.");
	    	}
	    } else {
	    	throw new PendingException("Erro ao verificar o saque, cliente comum: Cliente diferente do esperado, nesse caso, 'comum'.");
	    }
	}
	
	/**
	 * 	@author Sérgio Vicente Tavuencas
	 *	@param saldo representa o valor que será atribuído a variável saldoCliente.
	 *	@implNote O método verifica o tipo de cliente e se o saldoCliente é maior
	 *	que saqueCliente.
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
