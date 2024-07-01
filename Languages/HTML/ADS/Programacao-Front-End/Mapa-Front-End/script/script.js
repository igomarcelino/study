var homens = 0;
var mulheres = 0;
var criancas = 0;

document.getElementById('btnCalcular').addEventListener('click',function(){

    // obtendo os valores dos input

    homens = parseInt(document.getElementById('homens').value,10) ;
    mulheres = parseInt(document.getElementById('mulheres').value,10);
    criancas = parseInt(document.getElementById('criancas').value,10);

    /**
     * calculando os valores utilizando a tabela como referencia
     * Homens :
     * Carne bovina: 500g
     * Frango: 200g
     * Linguica 200g
     * Refrigerante: 300ml
     * Cerveja: 800ml
     * 
     * Mulhres :
     * Carne bovina: 300g
     * Frango: 200g
     * Linguica 200g
     * Refrigerante: 400ml
     * Cerveja: 500ml
     * 
     * Criancas: 
     * Carne bovina: 200g
     * Frango: 100g
     * Linguica 200g
     * Refrigerante: 200ml
     * Cerveja: 0
     */
    var carneBovina = (homens * 0.500) + (mulheres* 0.300) + (criancas * 0.200);
    var frango =  (homens * 0.200) + (mulheres* 0.200) + (criancas * 0.100);
    var linguica = (homens * 0.200) + (mulheres* 0.200) + (criancas * 0.200);
    var refrigerante = (homens * 0.300) + (mulheres* 0.400) + (criancas * 0.200);
    var cerveja = (homens * 0.800) + (mulheres* 0.400);

    //atribuindo a lista em uma variavel

    var lista = document.getElementById('listaItens');

    // apagando a lista
    lista.innerHTML = '';

    // Criando os elementos li
    var liCarneBovina = document.createElement('li');
    var liFrango = document.createElement('li');
    var liLinguica = document.createElement('li');
    var liRefrigerante = document.createElement('li');
    var liCerveja = document.createElement('li');

    // atribuindo os valores das variaveis de quantidade e concatenando com suas descricoes de quantidades
    if( !isNaN(homens && mulheres && criancas) ){
        liCarneBovina.textContent = carneBovina.toFixed(1) + 'Kg de carne bovina';
        liFrango.textContent = frango.toFixed(1) + 'Kg de frango';
        liLinguica.textContent = linguica.toFixed(1) + 'Kg de linguica';
        if(refrigerante >= 1){
            liRefrigerante.textContent = refrigerante.toFixed(1) + 'l de refrigerante';
        }else{
        liRefrigerante.textContent = refrigerante.toFixed(3) + 'ml de refrigerante';
        }
        if(cerveja >= 1){
            liCerveja.textContent = cerveja.toFixed(1) + 'l de cerveja';
        }else{
            liCerveja.textContent = cerveja.toFixed(3) + '  ml de cerveja';
        }
    }else{
        alert('Proibido campos vazio!!');
        liCarneBovina.textContent='Kg carne bovina';
        liFrango.textContent = 'Kg de frango';
        liLinguica.textContent = 'Kg de linguica';
        liRefrigerante.textContent = 'l de refrigerante';
        liCerveja.textContent = 'l de cerveja';
        lista.appendChild(liCarneBovina);
        lista.appendChild(liFrango);
        lista.appendChild(liLinguica);
        lista.appendChild(liRefrigerante);
        lista.appendChild(liCerveja);
        console.log(criancas);
    }
    

    // inserindo os elementos li dentro de nossa lista
    lista.appendChild(liCarneBovina);
    lista.appendChild(liFrango);
    lista.appendChild(liLinguica);
    lista.appendChild(liRefrigerante);
    lista.appendChild(liCerveja);


})