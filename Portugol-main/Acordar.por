programa{
  funcao inicio(){
    // Declaração de variáveis
    logico DespertadorLigado
    logico AbrirOlho
    logico Levantar
    logico CalcarChinelo
    logico PortaAberta
    logico PegarChave
    logico AbrirPorta
    logico Sair

    // Verifica se o despertador está ligado
        se(DespertadorLigado == verdadeiro)
        {
            AbrirOlho = verdadeiro
            Levantar = verdadeiro
            CalcarChinelo = verdadeiro
            
            // Verifica se a porta está aberta
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