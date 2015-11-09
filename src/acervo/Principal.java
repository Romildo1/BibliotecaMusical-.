
package acervo;

/**
 *
 * @author romildo
 */
import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) {

		//==============================
		//Exemplo de inserção de 1 Genero SGBD
		//==============================
		Genero r = new Genero ("Pop");
		if(Conexao.inserir(r)!=0) {
			System.out.println("Genero inserido com sucesso no banco!");
		} else {
			System.out.println("Erro na inserção!");
		}
                //==============================
		//Exemplo de inserção de outro Artista no SGBD
		//==============================
		 Artista m = new Artista("Phill Collins");
		if(Conexao.inserir(m)!=0) {
			System.out.println("Artista  inserido com sucesso no banco!");
		} else {
			System.out.println("Erro na inserção!");
		} 
                
                //==============================
		//Exemplo de inserção de outro Album no SGBD
		//==============================
                
                Album c = new Album("Toch",20008);
		if(Conexao.inserir(c)!=0) {
			System.out.println("Album  inserido com sucesso no banco!");
		} else {
			System.out.println("Erro na inserção!");
		}  
                
                //==============================
		//Exemplo de inserção de outro Música no SGBD
		//==============================
                
                Musica l = new Musica ("Invisible",10,3);
		if(Conexao.inserir(l)!=0) {
			System.out.println("Música  inserida com sucesso no banco!");
		} else {
			System.out.println("Erro na inserção!");
		}
                
                
		ResultSet res = Conexao.relatorio();
		if(res!=null) {
			try {
				while(res.next()) {
                                    
                                        System.out.println("*==========*");
					System.out.print("Artista: "+res.getString("Artista"));
					System.out.print(" / Genero: "+res.getString("Genero"));
					System.out.print(" / Album: "+res.getString("Album"));
                                        System.out.print(" / Ano: "+res.getInt("Ano"));
                                        System.out.println(" / Musica: "+res.getString("Musica"));
					System.out.println("==========");
					//System.out.println("Nome da Música: "+res.getString("nome"));
					//System.out.println("Nota Atribuída: "+res.getInt("nota"));
					//System.out.println("Duracao da Música: "+res.getInt("duracao"));
                                        //System.out.println("Musica: "+res.getString("musica"));
					//System.out.println("==========");
				}
			} catch (SQLException e) {
				System.out.println("Problema para exibir registros!");
			}
		} else {
			System.out.println("A pesquisa não retornou nenhum registro!");
		}
                
	}

}


