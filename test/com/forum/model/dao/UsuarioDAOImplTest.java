package com.forum.model.dao;

import com.forum.model.Usuario;
import java.util.List;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.DefaultTable;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.datatype.DataType;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class UsuarioDAOImplTest {
    
    JdbcDatabaseTester jdt;

    @Before
    public void setUp() throws Exception {
            jdt = new JdbcDatabaseTester("org.postgresql.Driver", "jdbc:postgresql://localhost:5433/usuarios","postgres","postgres");
            FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
            jdt.setDataSet(loader.load("/inicio.xml"));
            jdt.onSetup();
    }
    
    @Test
    public void testInserir() throws Exception {
        Usuario u = new Usuario("jose", "Jose Dias", "jose@dias.br", "XXXX", 0);
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        usuarioDAOImpl.inserir(u);

        IDataSet currentDataSet = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataSet.getTable("USUARIO");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataSet = loader.load("/aposInsercaoUsuario.xml");
        ITable expectedTable = expectedDataSet.getTable("USUARIO");
        Assertion.assertEquals(expectedTable, currentTable);	
    }

    @Test
    public void testRecuperar() throws Exception {
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        Usuario u = usuarioDAOImpl.recuperar("maria");

        DefaultTable currentTable = new DefaultTable("USUARIO_TESTE",
            new Column[] { 
                new Column("LOGIN", DataType.VARCHAR),
                new Column("NOME", DataType.VARCHAR),
                new Column("EMAIL", DataType.VARCHAR),
                new Column("SENHA", DataType.VARCHAR),
                new Column("PONTOS", DataType.BIGINT),
                });

        currentTable.addRow(new Object[] {u.getLogin(), u.getNome(), u.getEmail(), u.getSenha(), u.getPontos()});

        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataSet = loader.load("/buscaPorLogin.xml");
        ITable expectedTable = expectedDataSet.getTable("USUARIO");
        Assertion.assertEquals(expectedTable, currentTable);
    }

    @Test
    public void testAdicionarPontos() throws Exception {
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        usuarioDAOImpl.adicionarPontos("maria", 200);

        IDataSet currentDataSet = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataSet.getTable("USUARIO");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataSet = loader.load("/aposAtualizacaoUsuario.xml");
        ITable expectedTable = expectedDataSet.getTable("USUARIO");
        Assertion.assertEquals(expectedTable, currentTable);	
    }

    @Test
    public void testRanking() {
        UsuarioDAOImpl usuarioDAOImpl = new UsuarioDAOImpl();
        List<Usuario> lista = usuarioDAOImpl.ranking();
        assertEquals(2, lista.size());
        assertEquals("adias", lista.get(0).getLogin());
        assertEquals("maria", lista.get(1).getLogin());
    }
}
