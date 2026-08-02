from fastapi import FastAPI, Query
import requests

app = FastAPI() # essa linha cria uma instância da classe FastAPI, que é a aplicação web que será executada. A instância é armazenada na variável app, que será utilizada para definir as rotas e os endpoints da aplicação.

@app.get("/api/hello") # essa linha define uma rota para a aplicação, que será acessada através do método GET e do caminho "/api/hello". O decorador @app.get é utilizado para associar a função hello() à rota definida.

def hello_word(): # essa linha define a função hello(), que será executada quando a rota "/api/hello" for acessada. A função retorna uma mensagem de saudação em formato JSON.

    return {"message": "Hello, World!"} # essa linha retorna um dicionário com a chave "message" e o valor "Hello, World!", que será convertido para JSON e enviado como resposta para o cliente que acessou a rota.

@app.get("/api/restaurantes") # essa linha define uma rota para a aplicação, que será acessada através do método GET e do caminho "/api/restaurantes". O decorador @app.get é utilizado para associar a função listar_restaurantes() à rota definida.

def get_restaurantes(restaurante: str = Query(None)): # parâmetro renomeado para `restaurante` (singular)

    url = "https://guilhermeonrails.github.io/api-restaurantes/restaurantes.json" # essa linha define a URL da API externa que será utilizada para obter os dados dos restaurantes.

    response = requests.get(url) # essa linha faz uma requisição GET para a URL definida e armazena a resposta na variável response.

    if response.status_code == 200: # essa linha verifica se o status code da resposta é 200, indicando que a requisição foi bem-sucedida.
        dados_json = response.json() # essa linha converte o conteúdo da resposta para JSON e armazena na variável dados_json.

        if restaurante is None:
            return {'Dados': dados_json}

        dados_cardapio = []
        for item in dados_json:
            if item.get('Company') == restaurante:
                dados_cardapio.append({
                    "item": item.get('Item'),
                    "price": item.get('price') or item.get('Price'),
                    "description": item.get('description')
                })

        return {'Restaurante': restaurante, 'Cardapio': dados_cardapio}
    else:
        return {"error": "Não foi possível obter os dados dos restaurantes."} # caso a requisição não seja bem-sucedida, retorna uma mensagem de erro.