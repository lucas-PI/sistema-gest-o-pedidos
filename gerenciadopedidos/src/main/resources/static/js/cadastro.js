const formulario = document.getElementById("form-cadastro")

formulario.addEventListener("submit",async (evento) =>{
    evento.preventDefault();

    const nome = document.getElementById("nome").value.trim();
    const email = document.getElementById("email").value.trim();
    const senha = document.getElementById("senha").value;
    const confirmarSenha = document.getElementById("confirmar-senha").value;
    const typeUser = document.getElementById("tipo-usuario").value;

    if(!nome || !email || !senha || !confirmarSenha){
        alert("Preencha todos os campos!")
        return;
    }

    if(senha !== confirmarSenha){
        alert("As senhas não coincidem!")
        return;
    }

    const usuario = {
        name: nome,
        type: typeUser,
        password: senha
    };

    try{
        const resposta = await fetch("http://localhost:8080/users",{
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(usuario)
        });

        const dados = await resposta.json().catch(() => null);

        if(!resposta.ok){
            throw new Error(dados?.message|| dados?.messagem ||"Não foi possivel realizar o cadastro.");
        }

        alert("Usuário cadastrado com sucesso!")
        formulario.reset();
    }catch (erro){
        console.error("Erro no cadastro:",erro);
        alert(erro.message||"Não foi possível conectar ao servidor.");
    }
});