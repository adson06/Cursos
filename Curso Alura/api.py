import requests


url = "https://guilhermeonrails.github.io/api-restaurantes/restaurantes.json"
response = requests.get(url)

if response.status_code == 200:
    dados_json = response.json()
    dados_restaurante = {} # dicionário para armazenar os dados dos restaurantes
    for item in dados_json:
        nome_do_restaurante = item['Company']
        if nome_do_restaurante not in dados_restaurante:
            dados_restaurante[nome_do_restaurante] = [] # cria uma lista vazia para cada restaurante, que será preenchida com os itens do cardápio
        
        dados_restaurante[nome_do_restaurante].append({ # essa linha vai adicionar um dicionário com os dados do item do cardápio na lista do restaurante correspondente
            "item": item['Item'],
            "price": item['price'],
            "description": item['description']
        })

print(dados_restaurante['McDonald’s'])