programa{
  funcao inicio(){
    // Declara��o de vari�veis
    logico DespertadorLigado
    logico AbrirOlho
    logico Levantar
    logico CalcarChinelo
    logico PortaAberta
    logico PegarChave
    logico AbrirPorta
    logico Sair

    // Verifica se o despertador est� ligado
        se(DespertadorLigado == verdadeiro)
        {
            AbrirOlho = verdadeiro
            Levantar = verdadeiro
            CalcarChinelo = verdadeiro
            
            // Verifica se a porta est� aberta
            se(PortaAberta == verdadeiro)
            {
                Sair = verdadeiro
            }
            senao
            {
                PegarChave = verdadeiro
                AbrirPorta = verdadeiro
                Sair = verdadeiro
            }
        }

}