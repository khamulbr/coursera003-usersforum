package com.forum.model.dao;

import com.forum.model.Topico;
import com.forum.model.Usuario;
import java.util.List;
import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.DefaultTable;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.datatype.DataType;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class TopicoDAOImplTest {
    
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
        Topico t = new Topico("Topico de teste novo","Agora vai","adias");
        TopicoDAOImpl topicoDAOImpl = new TopicoDAOImpl();
        topicoDAOImpl.inserir(t);

        IDataSet currentDataSet = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataSet.getTable("TOPICO");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataSet = loader.load("/aposInsercaoTopico.xml");
        ITable expectedTable = expectedDataSet.getTable("TOPICO");
        Assertion.assertEquals(expectedTable, currentTable);	
    }

    @Test
    public void testRecuperar() throws Exception {
       TopicoDAOImpl topicoDAOImpl = new TopicoDAOImpl();
       Topico t = topicoDAOImpl.recuperar(1);

        DefaultTable currentTable = new DefaultTable("TOPICO_TESTE",
            new Column[] { 
                new Column("ID_TOPICO", DataType.BIGINT),
                new Column("TITULO", DataType.VARCHAR),
                new Column("CONTEUDO", DataType.VARCHAR),
                new Column("LOGIN", DataType.VARCHAR),
                });

        currentTable.addRow(new Object[] {t.getId(), t.getTitulo(), t.getConteudo(), t.getLogin()});

        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataSet = loader.load("/buscaPorTopico.xml");
        ITable expectedTable = expectedDataSet.getTable("TOPICO");
        Assertion.assertEquals(expectedTable, currentTable);
    }

    @Test
    public void testListaTopicos() {
        TopicoDAOImpl instance = new TopicoDAOImpl();
        List<Topico> lista = instance.listaTopicos();
        
        assertEquals(3, lista.size());
        assertEquals(1, lista.get(0).getId());
        assertEquals(2, lista.get(1).getId());
        assertEquals(3, lista.get(0).getId());
    }
    
}
