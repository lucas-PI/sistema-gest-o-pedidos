let atualPage = 0;
let size = 5;
let totalPage = 0;

async function carregarPedidos() {

    const resulte = await fetch(`http://localhost:8080/orders?page=${atualPage}&size=${size}`, {
        method: "GET",
    });

    const page = await resulte.json();
    const content = page.content;

    totalPage = page.totalPages - 1;

    const listaPedidos = document.querySelector("#listaPedidos");
    if (content.length === 0){
        listaPedidos.innerHTML = `<h3 class="msg-sem-pedidos">Nenhum pedido encontrado</h3>`;
    }else {
        listaPedidos.innerHTML = "";
            content.forEach((pedido) =>{
                const card = `
                    <article class="card-pedido">
                        <h4>Pedido #${pedido.id}</h4>
                        <p>${pedido.description}</p>
                        <p>${pedido.progressStatus}</p>
                        <p>${pedido.idUser}</p>
                    </article>
                `;
               listaPedidos.innerHTML += card;
            });
    };

}
carregarPedidos();

const btnUpPage =document.querySelector(".btn-up-page");

btnUpPage.addEventListener("click", function(){
    if(atualPage >= totalPage){
        btnUpPage.disabled = true;
    }else{
        atualPage += 1;
        carregarPedidos()
        btnDownPage.disabled = atualPage <= 0;
    }
})

const btnDownPage =document.querySelector(".btn-down-page");

btnDownPage.addEventListener("click", function(){
    if(atualPage <= 0){
        btnDownPage.disabled = true;
    }else{
        atualPage -= 1;
        carregarPedidos()
        btnUpPage.disabled = atualPage >= totalPage;
    }
})