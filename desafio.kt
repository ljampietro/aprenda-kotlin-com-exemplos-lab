enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, val idade: Int)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    
    /**
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    **/
    
    fun matricular(vararg usuarios: Usuario) = usuarios.forEach { inscritos.add(it) }
    
    /** 
    fun alunosInscritos() = inscritos.forEach { aluno  -> println("${aluno.nome}, Idade: ${aluno.idade}")    
    **/
    
    fun alunosInscritos() = inscritos.forEach {println("${it.nome}, Idade: ${it.idade}")}
    
    fun listaDeConteudos() = conteudos.forEach { println("${it.nome}, Duração: ${it.duracao} Horas")}
    
    
}

fun main() {

    // Novos alunos
	
    val usuario1 = Usuario("Lucas", 30)
    val usuario2 = Usuario("Nat", 28)
    val usuario3 = Usuario("Zion", 37)
    val usuario4 = Usuario("Mare", 23)
  
    // Conteúdo das formações
    
    val conteudoKotlin: List<ConteudoEducacional> = listOf(
        ConteudoEducacional("Fundamentos Kotlin", 90),
        ConteudoEducacional("Kotlin na Prática", 60)
    )
	val conteudoKotlinMobile: List<ConteudoEducacional> = listOf(
    	ConteudoEducacional("Interface de Usuário", 60),
        ConteudoEducacional("Armazenamento de Dados", 90)
    )
    
    // Formações
    
    val kotlin = Formacao("Formação Kotlin", conteudoKotlin, Nivel.BASICO)
    val mobileKotlin = Formacao("Formação Desenvolvimento Android Mobile", conteudoKotlinMobile, Nivel.INTERMEDIARIO)
    

    //Matricula de novos alunos

    kotlin.matricular(usuario1, usuario2)
    //kotlin.matricular(usuario2)
    mobileKotlin.matricular(usuario3)
    mobileKotlin.matricular(usuario4)
    
    //Listagem de alunos por formação

    println(kotlin.nome)
    println("Nivel: ${kotlin.nivel}")
    println("Conteúdo da Formação:")
    kotlin.listaDeConteudos()
    println("Alunos Matriculados:")
    kotlin.alunosInscritos()
    println()
    println(mobileKotlin.nome)
    println("Nivel: ${mobileKotlin.nivel}")
    println("Conteúdo da Formação:")
    mobileKotlin.listaDeConteudos()
    println("Alunos Matriculados:")
    mobileKotlin.alunosInscritos()
    
}