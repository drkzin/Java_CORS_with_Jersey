package br.com.gunscontrol.controller;

import java.io.IOException;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;

/**
 * Trabalho desenvolvido para a disciplina de Web Services.<br/>
 * <br/>
 * Publicador desenvolvido em Jersey para tratar um CRUD de Produto.<br/>
 * <br/>
 * Base de Dados H2 utilizada para persistir os dados de Produto.<br/>
 * <br/>
 * Classes:<br/>
 * 	FormProduto<br/>
 * 	Metodos: 	inserirProduto			- Insere um novo produto com as informacoes obtidas via forumlario inserir_produto.html disponivel em WebContent.<br/>
 * 				buscaProdutoNome		- Busca um produto que contenha parte do nome ou descricao de acordo com o parametro informado.<br/>
 * 				atualizaQtdProdutoID	- Diminui 1 item no estoque do Produto informado.<br/>
 * 				removeProdutoID			- Recebe ID de referencia e remove da tabela Produto.<br/>
 * <br/>
 * 	BuscarProduto<br/>
 * 	Metodos:	listarProdutos			- Exibe na tela todos os produtos encontrados no Banco de Dados.<br/>
 * 				buscaProdutoID			- Busca pelo ID e exibe o Produto encontrado no Banco de Dados.<br/>
 * <br/>
 * <br/>
 * Pos-Graduacao em Desenvolvimento em Linguagem Java<br/>
 * Universidade Positivo<br/>
 * Professor: Marcelo Manhaes<br/>
 * <br/>
 * Bibliotecas dependentes:<br/>
 * 		h2-1.4.186.jar<br/>
 * 		http-2.2.1.jar<br/>
 * 		jersey-archive-1.19<br/>
 * <br/>
 * @author Mauricio Doerr
 * 
 * @since 18/04/2015
 * 
 * @version 1.0
 */
public class Publicador {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws Exception {
		
		ResourceConfig rc = new PackagesResourceConfig("br.com.gunscontrol");
		rc.getProperties().put("com.sun.jersey.spi.container.ContainerResponseFilters",
			    "com.sun.jersey.api.container.filter.LoggingFilter;br.com.gunscontrol.util.CrossDomainFilter");
		HttpServer server = HttpServerFactory.create("http://localhost:8081/", rc);
		server.start();

	}

}
