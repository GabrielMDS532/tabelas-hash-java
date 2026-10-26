# Tabelas Hash em Java

**Autor:** Gabriel Mendes da Silva  
**Curso:** Ciência da Computação — PUCPR

Este repositório reúne duas atividades sobre tabelas hash. As estruturas e os tratamentos de colisão foram implementados manualmente em Java.

## Organização

| Pasta | Atividade |
|---|---|
| `Atividade1_Encadeamento` | Tratamento de colisões com listas encadeadas ordenadas |
| `Atividade2_Rehashing` | Tratamento de colisões com sondagem linear circular |

Cada pasta contém seu próprio `src` e deve ser executada separadamente, pois as atividades possuem classes com os mesmos nomes.

## Atividade 1 — Encadeamento

A tabela possui 100 posições e recebe 1.000 tentativas de inserção de números gerados com `Random`, usando a seed `1090` e o intervalo de 0 a 100.000, inclusive.

A função hash calcula `chave % capacidade`. A primeira chave ocupa o campo principal da posição. As chaves que colidem são encaminhadas à lista encadeada daquela posição, com inserção em ordem crescente. Valores iguais a nós já existentes nessa lista não geram novos nós.

Ao final, o programa apresenta:

- O índice da maior lista de colisões, a chave principal da posição e os valores da lista.
- A quantidade de nós da maior lista, sem incluir a chave principal.
- A quantidade de posições com listas de colisões não vazias.
- A quantidade de posições vazias da tabela.
- As três últimas chaves encaminhadas às listas de colisões.

## Atividade 2 — Rehashing

A tabela possui 100 posições e recebe 100 tentativas de inserção, com a mesma seed `1090` e o mesmo intervalo de valores da primeira atividade. Novas inserções são bloqueadas ao atingir 90 posições ocupadas.

Quando ocorre uma colisão, a busca avança pelo próprio vetor usando `(indice + 1) % capacidade`. A chave original permanece inalterada. Uma chave já encontrada durante a busca não é inserida novamente.

O programa apresenta:

- O total de colisões contabilizadas durante as buscas.
- Até três chaves que sofreram mais colisões antes da inserção, com suas respectivas contagens.
- Os índices que permaneceram livres.

O ranking considera inserções com pelo menos uma colisão. Em empates, as comparações estritas preservam os candidatos anteriores nas posições de mesma contagem; o novo candidato pode ocupar uma posição inferior. O total de colisões acumula os encontros com posições ocupadas por outras chaves.

## Execução

1. Baixe ou clone o repositório.
2. Abra a pasta da atividade desejada como projeto ou módulo Java na IDE.
3. Configure o JDK compatível com o projeto e marque `src` como pasta de código-fonte, se necessário.
4. Execute a classe `Main` da atividade escolhida.

Como a seed é fixa, a sequência gerada e os resultados se repetem quando o programa é executado com as mesmas condições. Essa repetição permite comparar os testes.

## Desenvolvimento e transparência

Desenvolvi as implementações como exercício de aprendizagem, construindo e revisando o código durante os estudos. Utilizei auxílio de IA para esclarecer conceitos, analisar erros e revisar a documentação. A elaboração e a revisão deste README também tiveram auxílio de IA.
