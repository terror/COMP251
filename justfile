default:
  just --list

alias f := fmt

all: forbid fmt

clean:
  fd '.log|.gz|.aux|.fls|.toc|.fdb_latexmk|.out|.pre' -X rm

forbid:
  ./bin/forbid

fmt:
  fd .java | xargs google-java-format --replace

dev-deps:
  brew install gradle google-java-format fd ripgrep
