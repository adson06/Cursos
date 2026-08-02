let botaoproximo = document.querySelector('.proximo')
let listaimagens = document.querySelectorAll('img')
let botaoAnterior = document.querySelector('.anterior')

let contador = 0

botaoproximo.onclick = function passarSlide(){
    document.querySelector('img.ativo').classList.remove('ativo')

    if (contador < 2){
        contador = contador + 1
    }else{
        contador = 0
    }

    listaimagens[contador].classList.add('ativo')
}

botaoAnterior.onclick = function voltarSlide(){
    document.querySelector('img.ativo').classList.remove('ativo')
    if (contador > 0){
        contador = contador - 1
    }else{
        contador = 2
    }

    listaimagens[contador].classList.add('ativo')

}