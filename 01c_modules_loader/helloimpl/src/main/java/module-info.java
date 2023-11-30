module de.zettsystems.helloimpl {
    requires de.zettsystems.hello;

    provides de.zettsystems.hello.HelloService with
            de.zettsystems.helloimpl.HelloServiceImpl;
}