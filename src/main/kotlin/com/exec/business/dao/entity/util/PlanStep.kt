package com.exec.business.dao.entity.util

/**
 * Author: Vadym Polyanski;
 * Date: 21.09.17;
 * Time: 7:45.
 */
enum class PlanStep(val title: String, val description: String) {

    STEP_1("Set the foundations",
            "Ask yourself some fundamental questions about your plan, " +
                    "your planning, and your businessPlan. Answer them for yourself and your team. "),

    STEP_2("Know your businessPlan and your market",
            "This is where you make sure you have good market analysis," +
                    " including segmentation and target segment strategy, " +
                    "competitive analysis, a good sense of standard costs and" +
                    " how things are done in your specific industry, your specific" +
                    " location, with your specific match of resources."),

    STEP_3("Strategy: Identity, market, and focus",
            "Strategy is tailored to your company, so it’s always unique to " +
                    "your specific situation. There aren’t best practices for" +
                    " certain industries, or formulas anybody can use. It will be" +
                    " a combination of your company identity (what it’s good at, what" +
                    " it wants, what resources it has, things like that); it’s target" +
                    " market (what it sells to whom, why they want it, what they get" +
                    " out of it, who isn’t in the market, and why); and it’s strategic" +
                    " focus (recognition of how real strategy involves as much what you" +
                    " don’t do as what you do; the secret to failure is trying to do " +
                    "everything, or trying to please everybody)."),

    STEP_4("Basic numbers: Sales forecast, expense budget, starting costs, etc.",
            "Don’t worry too much about guessing the future accurately. It’s planning," +
                    " not accounting. You’ll have plenty of opportunities to review and" +
                    " revise in the future. Set up a manageable sales forecast, expense" +
                    " budget, and, if you’re starting a new company, startup costs including " +
                    "expenses and assets you need. This leads of course to cash flow, which is vital."),

    STEP_5("Who does what, when. Call it commitment",
            "Break the journey towards businessPlan goals into meaningful steps, with metrics" +
                    " — dates, deadlines, spending budgets, sales results — so you’ll be" +
                    " able to track. Bring in the people charged with getting things done," +
                    " and use discussions and planning process to develop commitment. Plans" +
                    " work when people are committed, not just involved. Your planning process" +
                    " is only going to work if it generates management, commitment, and tracking." +
                    " And that won’t happen unless there are concrete, specific, and measurable" +
                    " steps to track."),

    STEP_6("Dress and polish as required",
            "This step is where you stick to the businessPlan results, a form dictated by the function" +
                    " for your businessPlan. If you need the formal plan, fill in the words that your" +
                    " readers will look for, depending on the details; edit and polish, create the" +
                    " document you need. If you’re planning just for management and operations," +
                    " then make the important summaries available for the team members involved."),

    STEP_7("Review and revise, from now on",
            "Now you follow up with regularly-scheduled plan reviews involving yourself at" +
                    " least and, if there are more members on the team, the management team." +
                    " These meetings should be scheduled in advance, at least once a month," +
                    " and treated with respect and importance.");
}