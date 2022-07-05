package br.com.company.steps;

import br.com.company.core.RestProvider;
import br.com.company.domain.Usuario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static br.com.company.resources.UsuarioResource.SIMULAR_EMPRESTIMO;
import static br.com.company.resources.UsuarioResource.USUARIO_RESTRICAO;

public class StepsSimulacao extends RestProvider {


    @When("devo incluir uma pessoa via POST")
    public void criarUmaSimulacao(DataTable dataTable) {
        post(new Usuario(dataTable.asMap()), SIMULAR_EMPRESTIMO);
    }


    @When("devo consultar uma simulação com restrição via get {}")
    public void consutarRestricao(String cpf) {
        get(USUARIO_RESTRICAO + "/" + cpf);
    }

    @When("devo consultar uma simulação via get {}")
    public void consultarSimulacao(String cpf) {
        get(SIMULAR_EMPRESTIMO + "/" +  cpf);
    }

    @Then("validar mensagem no body {}")
    public void validarMensagem(String mensagem) {
        validarCampoPayload(mensagem, "mensagem");
    }

    @Then("validar inclusão da simulação no body {}")
    public void validarInclusaoDeCampo(String CPF) {
        validarCampoPayload(CPF, "cpf");
    }


    @Then("verificar codigo resposta {int}")
    public void verificarStatusCode(int statusCode) {
        validaStatusCode(statusCode);
    }

    Usuario usuarioAlterado;

    @Then("devo alterar nome do cliente da simulação pelo CPF")
    public void alterarUmaSimulacao(DataTable dataTable) {
        usuarioAlterado = new Usuario(dataTable.asMap());
        put(new Usuario(dataTable.asMap()), SIMULAR_EMPRESTIMO + "/" + dataTable.asMap().get("cpf"));
    }


    @Then("devo verificar se uma alteração foi realizada com sucesso.")
    public void verificarAlteracao() {

        Usuario usr = get(Usuario.class, SIMULAR_EMPRESTIMO + "/" +  usuarioAlterado.getCpf());

        Assert.assertEquals(usuarioAlterado.getCpf(), usr.getCpf());
        Assert.assertEquals(usuarioAlterado.getNome(), usr.getNome());
    }
}
