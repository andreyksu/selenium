package ru.annikonenkov.citilink.pages;

import ru.annikonenkov.citilink.parts.content.PartContent;
import ru.annikonenkov.citilink.parts.footer.PartFooter;
import ru.annikonenkov.citilink.parts.header.PartHeader;
import ru.annikonenkov.citilink.parts.mainnavigation.PartMainNavigation;
import ru.annikonenkov.citilink.type.page_and_parts.PageCitilinkRegistry;
import ru.annikonenkov.common.utils.ISearchAndAnalyzeElement;
import ru.annikonenkov.common.worker.APageWorker;

/*
 * TODO: Подумать над дем, чтоб делать не статический набор - а именно через Фабрику. Т.е. тест или некий воркер вызывает не старинцу в таком виде а фабрику.
 * Потом произошлии изменения (допустим от клика) и снова через фабрику получили страницу. Но встает вопрос с тем как получать доступ к конкретному Part. По
 * имени, уже проходил, не удобно. Плюс придется кастить.
 */
public class MainPageOfCitilink extends APageWorker {

    public final PartHeader<MainPageOfCitilink> HEADER_PART;

    public final PartMainNavigation<MainPageOfCitilink> NAVIGATION_MENU_PART;

    public final PartContent<MainPageOfCitilink> CONTENT_PART;

    public final PartFooter<MainPageOfCitilink> FOOTER_PART;

    public MainPageOfCitilink(ISearchAndAnalyzeElement searcher) {
        super(PageCitilinkRegistry.MAIN_PAGE_OF_CITILINK, searcher);

        HEADER_PART = new PartHeader<>(this);
        NAVIGATION_MENU_PART = new PartMainNavigation<>(this);
        CONTENT_PART = new PartContent<>(this);
        FOOTER_PART = new PartFooter<>(this);

        addPartToPage(HEADER_PART);
        addPartToPage(NAVIGATION_MENU_PART);
        addPartToPage(CONTENT_PART);
        addPartToPage(FOOTER_PART);
    }

}
