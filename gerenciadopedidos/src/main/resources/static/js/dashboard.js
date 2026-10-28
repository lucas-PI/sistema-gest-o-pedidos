async function carregarPedidos() {
    const resulte = await fetch("http://localhost:8080/orders", {
        method: "GET",
    });

    const page = await resulte.json();
    const content = page.content;

    const listaPedidos = document.querySelector("#listaPedidos");
    if (content.length === 0){
        listaPedidos.innerHTML = "Nenhum pedido encontrado";
    }else {
        content.forEach((pedido) =>{
            console.log(pedido.id);
            console.log(pedido.description);
            console.log(pedido.idUser);
            console.log(pedido.progressStatus)
        })
    };

//    console.log(content)
}

carregarPedidos();

