# BAZINGA

Esta aplicação possui apenas três serviços:

* Serviço de Criação de Usuario 
* Serviço de Criação de Lista 
* Serviço de Criação de Blog

Base de dados: AWS DynamoDB


Cada serviço tem por finalidade otimizar e facilitar as utilizações com front, para incluir, excluir, alterar ou remover
qualquer informção.


✅ Features
Status: Opcional

Você pode listar as funcionalidades da aplicação.

É opcional, porém é muito importante colocar. Isso ajuda demais as pessoas entenderem o que já tem feito, 
se estiver em construção você vai checkando o que está pronto.


Baixa uma versão em seu amibiente de desenvolvimento, fique a vontade para modificar de acordo com suas necessidades.


GIT

Primeiros Comandos
git init
git add .
git commit -m "first commit"
git remote add origin https://github.com/seu-usuario/Nome-do-Repo-Remoto.git
git push -u origin master
Obtendo ajuda
Geral
git help
Comando específico
git help add
git help commit
git help <qualquer_comando_git>
Configuração
Geral
As configurações do GIT são armazenadas no arquivo .gitconfig localizado dentro do diretório do usuário do Sistema Operacional (Ex.: Windows: C:\Users\Documents and Settings\Leonardo ou *nix /home/leonardo).

As configurações realizadas através dos comandos abaixo serão incluídas no arquivo citado acima.

Configurar usuário
git config --global user.name "Rodrigo Alves"
Configurar email
git config --global user.email igo.sud@hotmail.com
Configurar editor
git config --global core.editor code
Configurar ferramenta de merge
git config --global merge.tool vimdiff
Configurar arquivos a serem ignorados
git config --global core.excludesfile ~/.gitignore
Listar configurações
git config --list
Usar saídas do git coloridas
git config color.ui true
Exibir log em apenas uma linha por commit
git config format.pretty oneline
=====================================================

Ignorar Arquivos
Os nomes de arquivos/diretórios ou extensões de arquivos listados no arquivo .gitignore não serão adicionados em um repositório. Existem dois arquivos .gitignore, são eles:

Geral: Normalmente armazenado no diretório do usuário do Sistema Operacional. O arquivo que possui a lista dos arquivos/diretórios a serem ignorados por todos os repositórios deverá ser declarado conforme citado acima. O arquivo não precisa ter o nome de .gitignore.

Por repositório: Deve ser armazenado no diretório do repositório e deve conter a lista dos arquivos/diretórios que devem ser ignorados apenas para o repositório específico.

Existem alguns arquivos que muito provavelmente você não vai precisar versionar, como por exemplo os arquivos de cache do SASS, arquivos de configuração e etc. Nesse caso você precisa fazer com que o controle de versão ignore estes arquivos. Para tanto, crie um arquivo chamado .gitignore. Feito isso, dentro deste arquivo, digite o nome ou o endereço das pastas que você quer ignorar. Um exemplo:

See http://help.github.com/ignore-files/ for more about ignoring files.
If you find yourself ignoring temporary files generated by your text editor or operating system, you probably want to add a global ignore instead:
git config --global core.excludesfile ~/.gitignore_global
Ignore bundler config
/.bundle

Ignore the build directory
/build

Ignore Sass' cache
/.sass-cache

Ignore .DS_store file
.DS_Store .cache .rvmrc

vendor/*

Vim
*.swp *.swo

rbenv
.ruby-version

Ignore deploy related files
deploy

Gemfile.lock .vagrant Vagrantfile

O arquivo .gitignore fica na raiz do projeto.
=====================================================

Repositório Local
Criar novo repositório
Entre no diretório que deseja controlar a versão e inicie o Git assim:

git init
Feito isso, seus arquivos ainda não estão sendo versionados, mas eles estão esperando para serem adicionados no estágio de controle. Para fazer isso digite o comando

git add nome-do-arquivo-incluindo-extensão
Verificar estado dos arquivos/diretórios
Saber o status do projeto é importante. Com o comando abaixo você consegue ver quais arquivos estão fora do controle, quais foram modificados e estão esperando por uma descrição de modificação etc:

git status
Status
Modificado (modified);
Preparado (staged/index)
Consolidado (comitted);
Adicionar arquivo/diretório (staged area)
Adicionar um arquivo em específico
git add meu_arquivo.txt
Adicionar um diretório em específico
git add meu_diretorio
Adicionar todos os arquivos/diretórios
Se você precisa adicionar todos os arquivos do diretório, basta digitar:

git add .	
Adicionar um arquivo que esta listado no .gitignore (geral ou do repositório)
git add -f arquivo_no_gitignore.txt
Fazer inclusões interativas
git add -i
Voltando ao estágio anterior do adicionamento:
git reset HEAD nome-do-arquivo
=====================================================

Commit – Comitando: Comitar arquivo/diretório
Comitar um arquivo
git commit meu_arquivo.txt
Comitar vários arquivos
git commit meu_arquivo.txt meu_outro_arquivo.txt
Comitar informando mensagem
git commit meuarquivo.txt -m "minha mensagem de commit"
Adicionando e comitando ao mesmo tempo:
git commit -a -m "Mensagem do commit"
Voltando commits a versões anteriores
Modificando seu último commit:
$ git commit --amend
Voltar um commit:
git reset HEAD~1
Voltar dois commits:
git reset HEAD~2
Voltando um commit e deixando o arquivo no estagio anterior:
git reset HEAD~1 --soft
Voltando um commit e excluindo o arquivo, deixando no estágio anterior:
git reset HEAD~1 --hard
voltar somente um arquivo para o commit anterior:
Se o arquivo ainda não está commited:

git checkout -- [path]
Se já foi committed e quer voltar pro commit imediatamente anterior ao HEAD:

git reset HEAD~1 [path]
Ou

git checkout HEAD~1 [path]
=====================================================

Remover arquivo/diretório
Remover arquivo
git rm meu_arquivo.txt
Remover diretório
git rm -r diretorio
Deletando todos os aquivos removidos ao mesmo tempo:
git ls-files --deleted | xargs git rm
=====================================================

Visualizar hitórico
Exibir histórico - Verificando o histórico de commits:
git log
Verificando o que foi mudado, diferença (diff) entre um arquivo e outro:
git log -p
Exibir histórico com diff das duas últimas alterações
git log -p -2
Exibir resumo do histórico (hash completa, autor, data, comentário e qtde de alterações (+/-)). Mostrando as estatísticas de todos os commits:
git log --stat
Exibir informações resumidas em uma linha (hash completa e comentário)
git log --pretty=oneline
Exibir histórico com formatação específica (hash abreviada, autor, data e comentário)
git log --pretty=format:"%h - %an, %ar : %s"
%h: Abreviação do hash;
%an: Nome do autor;
%ar: Data;
%s: Comentário.
Verifique as demais opções de formatação no Git Book

Exibir histório de um arquivo específico
git log -- <caminho_do_arquivo>
Mostrando todos os commits dos últimos 2 dias até o momento atual
git log --since=2.days
Exibir histórico de um arquivo específico que contêm uma determinada palavra
git log --summary -S<palavra> [<caminho_do_arquivo>]
Exibir histórico modificação de um arquivo
git log --diff-filter=M -- <caminho_do_arquivo>
O pode ser substituido por: Adicionado (A), Copiado (C), Apagado (D), Modificado (M), Renomeado (R), entre outros.
Exibir histório de um determinado autor
git log --author=usuario
Exibir revisão e autor da última modificação de uma bloco de linhas
git blame -L 12,22 meu_arquivo.txt
Reescrevendo o histórico
Alterando mensagens de commit
git commit --amend -m "Minha nova mensagem"
Alterar últimos commits
Alterando os três últimos commits

git rebase -i HEAD~3
O editor de texto será aberto com as linhas representando os três últimos commits.

pick f7f3f6d changed my name a bit
pick 310154e updated README formatting and added blame
pick a5f4a0d added catfile
Altere para edit os commits que deseja realizar alterações.

edit f7f3f6d changed my name a bit
pick 310154e updated README formatting and added blame
pick a5f4a0d added catfile
Feche o editor de texto.

Digite o comando para alterar a mensagem do commit que foi marcado como edit.

git commit –amend -m “Nova mensagem”
Aplique a alteração

git rebase --continue
Atenção: É possível alterar a ordem dos commits ou remover um commit apenas mudando as linhas ou removendo.

Outra forma de alterar texto de commits
Primeiro passo:

git rebase -i --root
Com este comando será aberto o VIM. Então siga estes passos:

Delete o comentário ou a parte que deseja alterar do comentário usando a tecla delete
clica emcima da palavra "pick" antes do comentário e aperte 'S'
ao aparece embaixo "-- INSERÇÃO --", digite 'r'
aperte CTRL + C, digite ':wq'
Você será direcionado para outro arquivo, sendo esse específico do comentário, para alterar também. Siga apenas os passos anteriores e saia do VIM. Aguarde o termino do comando "rebase"
Saindo de Arquivo "VIM"
:wq
Juntando vários commits
Seguir os mesmos passos acima, porém marcar os commtis que devem ser juntados com *squash

Remover todo histórico de um arquivo
git filter-branch --tree-filter 'rm -f passwords.txt' HEAD
=====================================================

Criando um branch – uma ramificação
git checkout -b nome-do-branch
Verificando em que branch você está
git branch
Voltando para o branch master
git checkout master
Jogando o branch criado no branch master
Entre como branch master:
git merge nome-do-branch-que-foi-criado
Grudando o branch criado no branch master sem o commit
Somente localmente – localhost, entre como branch master:
git rebase nome-do-branch-que-foi-criado
Removendo um branch:
git branch -D nome-do-branch
Vendo branchs remotos:
git branch -a
Buscar as alterações, mas não aplica-las no branch atual
git fecth
=====================================================

Desfazendo operações
Desfazendo alteração local (working directory)
Este comando deve ser utilizando enquanto o arquivo não foi adicionado na staged area.

git checkout -- meu_arquivo.txt
Desfazendo alteração local (staging area)
Este comando deve ser utilizando quando o arquivo já foi adicionado na staged area.

git reset HEAD meu_arquivo.txt
Se o resultado abaixo for exibido, o comando reset não alterou o diretório de trabalho.

Unstaged changes after reset:
M	meu_arquivo.txt
A alteração do diretório pode ser realizada através do comando abaixo:

git checkout meu_arquivo.txt
=====================================================

Repositório Remoto
Exibir os repositórios remotos
git remote

git remote -v
Vincular repositório local com um repositório remoto
git remote add origin git@github.com:leocomelli/curso-git.git
Exibir informações dos repositórios remotos
git remote show origin
Renomear um repositório remoto
git remote rename origin curso-git
Desvincular um repositório remoto
git remote rm curso-git
=====================================================

Enviar arquivos/diretórios para o repositório remoto
O primeiro push de um repositório deve conter o nome do repositório remoto e o branch.

git push -u origin master
Os demais pushes não precisam dessa informação

git push
Enviando um branch para o repositório:
git push origin nome-do-branch
=====================================================

Atualizar repositório local de acordo com o repositório remoto
Trazendo, puxando as alterações feitas por outros usuários:

git pull origin master
Atualizar os arquivos no branch atual
Sincronizando tudo que está no repositório remoto:

git pull
Buscar as alterações, mas não aplica-las no branch atual
git fecth
=====================================================

Clonar um repositório remoto já existente
Use o comando git clone url-do-projeto. Exemplo:

git clone git@github.com:leocomelli/curso-git.git
Fazendo um clone de outros branchs:
git checkout -b nome-do-branch origin/ nome-do-branch
=====================================================

Tags
As tags servem para marcar uma etapa. Imagine que você vai lançar uma versão, que resolve uma série de problemas. Você pode marcar aquela etapa criando uma tag. Assim fica simples de fazer qualquer rollback do projeto para uma tag específica em vez de voltar para um commit. Você sabe que tudo o que foi feito até aquela tag está funcionando.

Criando uma tag leve
git tag vs-1.1
(git tag versão-da-tag)
Listando tags:
git tag -l
Criando uma tag anotada
git tag -a vs-1.1 -m "Minha versão 1.1"
Criando uma tag assinada
Para criar uma tag assinada é necessário uma chave privada (GNU Privacy Guard - GPG).

git tag -s vs-1.1 -m "Minha tag assinada 1.1"
Criando tag a partir de um commit (hash)
git tag -a vs-1.2 9fceb02
Criando tags no repositório remoto
git push origin vs-1.2
Enviando a tag para o repositório
git push origin master --tags
Removendo as tags criadas localmente:
git tag -d versão-da-tag

Removendo tag no repositório remoto:
git push origin :refs/tags/versão-da-tag

=====================================================

Branches
O master é o branch principal do GIT.

O HEAD é um ponteiro especial que indica qual é o branch atual. Por padrão, o HEAD aponta para o branch principal, o master.

Criando um novo branch
git branch bug-123
Trocando para um branch existente
git checkout bug-123
Neste caso, o ponteiro principal HEAD esta apontando para o branch chamado bug-123.

Criar um novo branch e trocar
git checkout -b bug-456
Voltar para o branch principal (master)
git checkout master
Resolver merge entre os branches
git merge bug-123
Para realizar o merge, é necessário estar no branch que deverá receber as alterações. O merge pode automático ou manual. O merge automático será feito em arquivos textos que não sofreram alterações nas mesmas linhas, já o merge manual será feito em arquivos textos que sofreram alterações nas mesmas linhas.

A mensagem indicando um merge manual será:

Automerging meu_arquivo.txt
CONFLICT (content): Merge conflict in meu_arquivo.txt
Automatic merge failed; fix conflicts and then commit the result.
Apagando um branch
git branch -d bug-123
Listar branches
Listar branches
git branch
Listar branches com informações dos últimos commits
git branch -v
Listar branches que já foram fundidos (merged) com o master
git branch --merged
Listar branches que não foram fundidos (merged) com o master
git branch --no-merged
Criando branches no repositório remoto
Criando um branch remoto com o mesmo nome
git push origin bug-123
Criando um branch remoto com nome diferente
git push origin bug-123:new-branch
Baixar um branch remoto para edição
git checkout -b bug-123 origin/bug-123
Apagar branch remoto
git push origin:bug-123
Rebasing
Fazendo o rebase entre um o branch bug-123 e o master.

git checkout experiment

git rebase master
Mais informações e explicações sobre o Rebasing

Stash - Arquivar e restaurar alterações incompletas
Para alternar entre um branch e outro é necessário fazer o commit das alterações atuais para depois trocar para um outro branch. Se existir a necessidade de realizar a troca sem fazer o commit é possível criar um stash. O Stash como se fosse um branch temporário que contem apenas as alterações ainda não commitadas.

Criar um stash
git stash
Listar stashes
git stash list
Voltar para o último stash
git stash apply
Voltar para um stash específico
git stash apply stash@{2}
Onde 2 é o indíce do stash desejado.

Restaurar os arquivos stashed mais recente
git stash pop
Descarta o changeset stash mais recente
git stash drop
Descarta o changeset stash específico
git stash drop [ nome do stash ]
Criar um branch a partir de um stash
git stash branch meu_branch
======================================================

Bisect
O bisect (pesquisa binária) é útil para encontrar um commit que esta gerando um bug ou uma inconsistência entre uma sequência de commits.

Iniciar pequinsa binária
git bisect start
Marcar o commit atual como ruim
git bisect bad
Marcar o commit de uma tag que esta sem o bug/inconsistência
git bisect good vs-1.1
Marcar o commit como bom
O GIT irá navegar entre os commits para ajudar a indentificar o commit que esta com o problema. Se o commit atual não estiver quebrado, então é necessário marca-lo como bom.

git bisect good
Marcar o commit como ruim
Se o commit estiver com o problema, então ele deverá ser marcado como ruim.

git bisect bad
Finalizar a pesquisa binária
Depois de encontrar o commit com problema, para retornar para o HEAD utilize:

git bisect reset
=====================================================

Manutenção
Ocasionalmente, Git automaticamente executa um comando chamado "auto gc". Na maioria das vezes, este comando não faz nada. No entanto, se houverem muitos objetos soltos (loose objects) (objetos que não estejam em um packfile) ou muitos packfiles, Git executa um verdadeiro comando git gc. O gc significa garbage collect (coleta de lixo), e o comando faz uma série de coisas: ele reúne todos os objetos soltos e os coloca em packfiles, consolida packfiles em um packfile maior, e remove objetos que não estejam ao alcance de qualquer commit e tem poucos meses de idade.

Você pode executar auto gc manualmente da seguinte forma:

git gc --auto
=====================================================

Concluindo
Se você quer continuar ou iniciar seus estudos com Git, o pessoal da CodeSchool juntamente com o GitHub fizeram uma página exclusivamente para ensinar Git na prática. Visite aqui: https://try.github.io/levels/1/challenges/1

Há também a documentação do Git que é bastante completa: http://www.git-scm.com/doc

E a página de ajuda em português tem várias informações necessárias para iniciantes no GitHub: https://help.github.com/pt

Um guia SUPER PRÁTICO: http://rogerdudler.github.io/git-guide/index.pt_BR.html

Um guia rápido, em inglês, porém excelente e enxuto: https://services.github.com/on-demand/downloads/github-git-cheat-sheet.pdf

E outro, também em inglês, totalmente interativo: http://ndpsoftware.com/git-cheatsheet.html#loc=workspace;

E mais esse (LEARN GIT IN AN INTERACTIVE WAY), interativo também, através dos comandos do git: https://wethefoss.github.io/Git-Commands/

Já esse treinamento interativo é em português e muito bom também: https://learngitbranching.js.org/?locale=pt_BR

Livro Pro Git, escrito por Scott Chacon e Ben Straub e publicado pela Apress, está disponível aqui. Todo o conteúdo está licenciado sob a licença Creative Commons Attribution Non Commercial Share Alike 3.0. https://www.git-scm.com/book/pt-br/v2

Para quem ainda tem dúvidas sobre os comandos do Git: https://gitexplorer.com/

FAQ sobre git: https://www.git-tower.com/learn/git/faq/