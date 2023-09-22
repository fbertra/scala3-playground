cd $HOME

mkdir bin
cd bin

# curl -fL https://github.com/coursier/coursier/releases/latest/download/cs-x86_64-pc-linux.gz | gzip -d > cs && chmod +x cs && ./cs setup

curl -fL https://github.com/coursier/coursier/releases/latest/download/cs-x86_64-pc-linux.gz | gzip -d > cs && chmod +x cs

# sudo apt install clang lldb lld

sudo apt install libstdc++-12-dev

# sudo apt install libgc-dev