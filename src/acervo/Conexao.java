
package acervo;

/**
 *
 * @author romildo
 */

import java.sql.*;
public class Conexao {
    //Método para Conectar ao Banco de Dados Local chamado 'cadastro', usuário 'root' e senha em branco!
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost/bibliotecamusical", "root", "laser");
			return(c);
		} catch (ClassNotFoundException e) {
			System.out.println("Problema na configuração do Driver do MySQL!");
		} catch (SQLException e) {
			System.out.println("Problema na conexão com o banco de dados!");
		}
		return(null);
	}
	
	//Retorna o relatório contendo todos os dados do Banco
	public static ResultSet relatorio() {
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeQuery("SELECT artista.nome as Artista,genero.nome as genero,album.nome as Album,album.ano,musica.nome as Musica from artista,genero,album,musica where genero.id=artista.genero_id && artista.id=album.artista_id && album.id=musica.album_id group by album.id;\";"));
		} catch (SQLException e) {
			System.out.println("Problema na consulta à tabela genero!");
		}
		return(null);
	}
        
        
       
	//Método para inserir no banco um genero passada como parâmetro
	public static int inserir(Genero g) {
		String insercao = "INSERT INTO `genero` (`nome`) VALUES ('"+g.getNome()+"');";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(insercao));
		} catch (SQLException e) {
			System.out.println("Problema na inserção da genero!, ou ja existe");
		}
		return(0);
	}
	public static int inserir(Artista a) {
		String insercao = "INSERT INTO `artista` (`nome`,genero_id ) VALUES ('"+a.getNome()+"',1);";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(insercao));
		} catch (SQLException e) {
			System.out.println("Problema na inserção da artista!, ou ja existe");
		}
		return(0);
	}
        
        public static int inserir(Album a) {
		String insercao = "INSERT INTO `album` (`nome`,ano,artista_id ) VALUES ('"+a.getNome()+"','"+a.getAno()+"',1);";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(insercao));
		} catch (SQLException e) {
			System.out.println("Problema na inserção da artista!, ou ja existe");
		}
		return(0);
	}
        
        
        public static int inserir(Musica l) {
		String insercao = "INSERT INTO `musica` (`nome`, nota, duracao,album_id ) VALUES ('"+l.getNome()+"','"+l.getNota()+"','"+l.getDuracao()+"',1);";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(insercao));
		} catch (SQLException e) {
			System.out.println("Problema na inserção da Musica!, ou ja existe");
		}
		return(0);
	}
        
	//Método para Atualizar os campos no banco
	public static int atualizar(Genero g, String n) {
		String atualizacao = "UPDATE `artista` SET `nome` = '"+g.getNome()+"' WHERE `nome` = '"+n+"';";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(atualizacao));
		} catch (SQLException e) {
			System.out.println("Problema na atualização da genero!");
		}
		return(0);
	}
        
        public static int atualizar(Artista a, String n) {
		String atualizacao = "UPDATE `album` SET nome = '"+a.getNome()+"' WHERE nome = '"+n+"';";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(atualizacao));
		} catch (SQLException e) {
			System.out.println("Problema na atualização da artista!");
		}
		return(0);
	}
        
        public static int atualizar(Album a, String n) {
		String atualizacao = "UPDATE `musica` SET nome = '"+a.getNome()+"' WHERE nome = '"+n+"';";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(atualizacao));
		} catch (SQLException e) {
			System.out.println("Problema na atualização da artista do Album!");
		}
		return(0);
	}
        
        public static int atualizar(Musica l, String n) {
		String atualizacao = "UPDATE `musica` SET nome,nota,duracao = '"+l.getNome()+"','"+l.getNota()+"','"+l.getDuracao()+"' WHERE nome,nota,duracao = '"+n+"';";
		Connection con = conectar();
		Statement st;
		try {
			st = con.createStatement();
			return(st.executeUpdate(atualizacao));
		} catch (SQLException e) {
			System.out.println("Problema na atualização da Musica!");
		}
		return(0);
	}
    
	
}

   

