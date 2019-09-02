---
layout: page
title: Exercícios de Android
---

## Avaliação

A avaliação será realizada por meio de testes automatizados. Os casos de teste estão implementados na classe `CorrecaoTest`. Para obter a nota máxima, seu código deve passar em todos os casos de teste.

Para executar os casos de teste através do Android Studio, clique com o botão direito sobre a classe `CorrecaoTest` e escolha a opção `Run 'CorrecaoTest'`. Aguarde o final da execução.

Note que, para a correção oficial, os testes serão executados no emulador Genymotion, usando a máquina virtual "Custom Phone - 4.1.1 - API 16 - 768x1280". Recomenda-se o uso do Android Studio 2.3.3, pois o código inicial foi criado nessa versão da IDE.

## Forma de entrega

A entrega dos exercícios será feita através do [GitHub Classroom](https://classroom.github.com/) (não confundir com Google Classroom). Confira abaixo o link para a página do exercício no GitHub Classroom, que inclui informações como o prazo de entrega.

Você precisará usar o sistema de controle de versão Git para submeter o seu código como resposta dos exercícios. Na dúvida, consulte [estes slides sobre controle de versão com Git](https://docs.google.com/presentation/d/1QTLn7roYJw_Cfm_IWRL-KusmQgnlQ6YVG6ZWePLDIFQ/edit).

## Exercício 2 - Intent

Antes de iniciar a implementação, acesse o link do GitHub Classroom deste exercício para criar uma cópia do código base: <https://classroom.github.com/a/f18kiPz3>

```
+--------------------+      +--------------------+
|                    |      |                    |
|    Oi, Fulano!     |      |    Fulano          |
|                    |      |  +--------------+  |
| +----------------+ |      |                    |
| | Trocar usuário | +------>  +--------------+  |
| +----------------+ |      |  | Confirmar    |  |
|                    |      |  +--------------+  |
|                    |      |                    |
|                    |      |  +--------------+  |
|                    |      |  | Cancelar     |  |
|                    |      |  +--------------+  |
|                    |      |                    |
+--------------------+      +--------------------+
```

Seu app deve possuir duas activities: a `MainActivity` (exibida à esquerda no desenho acima), contendo um TextView com id `textView` e um botão com id `btnTrocar`, e a `OutraActivity`, contendo um EditText com id `editText` e dois botões, um com id `btnConfirmar` e outro com id `btnCancelar`.

Os botões devem ter o rótulo apresentado no desenho acima. O TextView inicialmente deve apresentar o texto "Oi!", e o EditText inicialmente deve vir vazio.

A lógica básica do app é que a mensagem na primeira tela cumprimenta o usuário atual com o texto `Oi, NOME!`, onde `NOME` é o nome do usuário atual. Ao clicar em "Trocar usuário", digitar um novo nome e então clicar em "Confirmar", muda-se o o usuário atual para aquele cujo nome foi digitado. Se o nome digitado for uma string vazia, isso sinaliza que não há nenhum usuário atual, e a mensagem deve ficar apenas "Oi!".

Ao abrir a `OutraActivity`, a caixa de texto deve mostrar o nome do usuário atual ou, se não houver usuário atual, ela deve estar limpa.

Como sempre, o app deve funcionar segundo a especificação mesmo se o usuário rotacionar a tela.
