package com.forum.model.dao;

import com.forum.model.Comentario;
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

public class ComentarioDAOImplTest {
    
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
        Comentario c = new Comentario("teste de comentario", "adias", 1);
        ComentarioDAOImpl comentarioDAOImpl = new ComentarioDAOImpl();
        comentarioDAOImpl.inserir(c);

        IDataSet currentDataSet = jdt.getConnection().createDataSet();
        ITable currentTable = currentDataSet.getTable("COMENTARIO");
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataSet = loader.load("/aposInsercaoComentario.xml");
        ITable expectedTable = expectedDataSet.getTable("COMENTARIO");
        Assertion.assertEquals(expectedTable, currentTable);		
    }

   
    @Test
    public void testBuscaPorTopico() throws Exception {
        ComentarioDAOImpl comentarioDAOImpl = new ComentarioDAOImpl();
        List<Comentario> comentarios = comentarioDAOImpl.buscaPorTopico(new Topico(1,"TÃ³pico de teste","Hooray","adias"));

        DefaultTable currentTable = new DefaultTable("COMENTARIO_TESTE",
            new Column[] { 
                new Column("ID_COMENTARIO", DataType.BIGINT),
                new Column("COMENTARIO", DataType.VARCHAR),
                new Column("LOGIN", DataType.VARCHAR),
                new Column("ID_TOPICO", DataType.BIGINT),
                });
        
        for(Comentario c: comentarios){
            currentTable.addRow(new Object[] {c.getId(), c.getComentario(), c.getLogin(), c.getIdTopico()});
        }
        
        FlatXmlDataFileLoader loader = new FlatXmlDataFileLoader();
        IDataSet expectedDataSet = loader.load("/buscaPorComentario.xml");
        ITable expectedTable = expectedDataSet.getTable("COMENTARIO");
        Assertion.assertEquals(expectedTable, currentTable);
    }
    
}
