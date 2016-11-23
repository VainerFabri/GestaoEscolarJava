import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Column;

import model.Curso;
import repository.Cursos;
import repository.Professores;

@ManagedBean
@ViewScoped
public class CursosBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	String codigo;
	String nome;
	
	List<Curso> cursos;
	
	@PostConstruct
	public void iniciaPagina()
	{
		cursos = Cursos.pegarTodosCursos();
	}
	
	public void Salvar()
	{	
		Curso curso = new Curso();
		curso.setCodigo(Integer.parseInt(codigo));
		curso.setNome(nome);

		Cursos.salvarUsuario(curso);
		org.primefaces.context.RequestContext.getCurrentInstance().execute("PF('cursos').hide()");
		try{
			cursos = Cursos.pegarTodosCursos();
			org.primefaces.context.RequestContext.getCurrentInstance().update("frmTabelas:tblCursos");
		}catch (Exception e) {
			
		}
	}
	
	public void excluir(Curso curso){
		Cursos.excluirCurso(curso);
		cursos = Cursos.pegarTodosCursos();
	}
	
	
	
	public void limpar()
	{ 
		codigo = "";
		nome = "";
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	
	
	
}
